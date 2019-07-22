package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Vote;
import com.example.demo.model.bean.VoteData;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.bean.VoterHasVote;
import com.example.demo.model.service.UserService;
import com.example.demo.model.service.VoteDataService;
import com.example.demo.model.service.VoteService;
import com.example.demo.model.service.VoterHasVoteService;
import com.example.demo.model.service.VoterService;

@Controller
public class OnvoteController {
	
	@Autowired
	private VoteService voteService;
	@Autowired
	private VoterService voterService;
	@Autowired
	private UserService userService;
	@Autowired
	private VoteDataService voteDataService;
	@Autowired
	private VoterHasVoteService voterHasVoteService;
	@Autowired
	private VoteData votedata;
	@Autowired
	private Vote vote;
	@Autowired
	private VoterHasVote voterHasVote;
	@Autowired
	private VoteData voteData;
	List temp=new ArrayList();
	List temp2=new ArrayList();
	
	/**
	 * 用户user
	 * 投票界面onvote.html
	 * @return
	 */
	@RequestMapping(value = "onvote")
	public ModelAndView index() {
		return new ModelAndView("onvote");
	}
	
	/**
	 * 用户voter
	 * 调用findAllVote()方法查找所有vote
	 * 传给govote。html
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "govote")
	public ModelAndView goVote(Model model) {
		List<Vote> votes = voteService.findAllVote();
		model.addAttribute("votes",votes);
		System.out.println(votes);
		return new ModelAndView("govote");
	}
	
	/**
	 * 用户voter
	 * 投票详细信息页面
	 * @return
	 */
	@RequestMapping(value = "vote")
	public ModelAndView Vote() {
		
		return new ModelAndView("vote");
	}
	
	/**
	 * 用户voter
	 * 接受govote.html的一个当前投票的id
	 * 根据id找到所有投票
	 * 传给vote.html
	 * @param id
	 * @param model
	 * @param session
	 * @return
	 */
	@GetMapping("vote")
	public String Vote(int id, Model model, HttpSession session) {
		System.out.println("vote id: "+id);
		session.setAttribute("id",id);
		
		Voter voter = (Voter) session.getAttribute("voter");
		String item = (String) session.getAttribute("item");
		int voterid = voter.getVoterId();
		voter.setVoterId(voterid);
		System.out.println("voter_id: "+voter.getVoterId());
//		VoterHasVote voterHasVote = voterHasVoteService.findVoteIdByVoterId(voterid);
//		System.out.println("voter_idddddddddddddddddddddddd: "+item);
//		if(voterHasVote.getVoterid()==voterid&&voterHasVote.getVoteid()!=id) {
//			System.out.println("voter_iiiiiiiiiiiii: "+voterHasVote.getVoteid());
//			Vote vote = voteService.selectVoteId(id);
//			model.addAttribute("votes",vote);
//			return "vote";
//		}
		Vote vote = voteService.selectVoteId(id);
		model.addAttribute("votes",vote);
		return "vote";
		
	}
	/**
	 * 用户user，新建投票
	 * 接受从onvote。html传过来的新建投票信息
	 * 将新建的投票保存到vote表
	 * 
	 * 调用insertVoteData()方法，在保存新建投票后接着去取出最后一个投票，将他保存到votedata中
	 * @param vote
	 * @param session
	 * @return
	 */
	@PostMapping(value="/addvote", headers = "Accept=application/json")
	@ResponseBody
	public int addVote(@RequestBody Vote vote, HttpSession session) {
		User user1 = (User) session.getAttribute("User");
//		Voter voter1 = (Voter) session.getAttribute("voter");//注意此处有bug,必须要登录voter，才能运行这一段，应将这一段封装到另一个方法里
//		int id1 = voter1.getVoterId();
//		vote.setVoterid(id1);
		Integer uid = user1.getId();
		vote.setVoteUid(uid);
		voteService.add(vote);
		insertVoteData();  //在votedata表插入票数信息
		return 1;
	}
	/**
	 * 在votedata表插入票数信息
	 * 
	 */
	public void insertVoteData() {
		
		List<Vote> vote1 = voteService.findAllVote(); //查找所有投票
		for (int i = 0; i < vote1.size(); i++) { // 遍历用户名跟获取到的用户名比较,,更新votedata
			
			if(i==vote1.size()-1) {
				int id = vote1.get(i).getVoteId();				
				votedata.setVoteid(id);
				voteDataService.insertVoteData(votedata);
				System.out.println("VOTE_ID:" + vote1.get(i).getVoteId());
			}
		}
	}
	
	/**
	 * 
	 * 提交投票
	 * @param selectvalue
	 * @param session
	 * @param model
	 * @return
	 */
	@PostMapping(value="/submitvote", headers = "Accept=application/json")
	@ResponseBody
	public int submitVote(@RequestBody String selectvalue, HttpSession session, Model model) {

	    JSONObject jsonObject = JSONObject.parseObject(selectvalue);
	    String item = jsonObject.getString("selectvalue"); //将json格式字符串转为字符串

	    insertVoterAndVote(session);
	    
	    session.setAttribute("item",item);
		int id = (int) session.getAttribute("id");	
		Vote vote1 = voteService.selectVoteId(id);  //根据id找出投票		

		
		if(vote1.getVoteFirstitem().equals(item)){
			voteDataService.increaseFirstNum(id);
			System.out.println("111");
		}
		else if(vote1.getVoteSeconditem().equals(item)){
			voteDataService.increaseSecondNum(id);
			System.out.println("222");
		}
		else if(vote1.getVoteThirditem().equals(item)) {
			voteDataService.increaseThirdNum(id);
			System.out.println("333");
		}
		return 1;
	}
	/**
	 * voterhasvote表保存voter自己已经投了票的投票信息
	 * 将vote_id和voter_id保存到数据表voterhasvote中
	 * @param session
	 */
	public void insertVoterAndVote(HttpSession session) {
		Voter voter1 = (Voter) session.getAttribute("voter");  //接受voterLoginController的session
		int voterid = voter1.getVoterId();  //取出session的管理者voterid
	    
		int id = (int) session.getAttribute("id");	
		Vote vote1 = voteService.selectVoteId(id);  //根据id找出投票		
		int voteid = vote1.getVoteId();
		
		voterHasVote.setVoterid(voterid);
		voterHasVote.setVoteid(voteid);	  
		voterHasVoteService.insertVoterAndVote(voterHasVote); //插入vote_id和voter_id保存到数据表voterhasvote中
	}

}
