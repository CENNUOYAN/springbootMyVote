package com.example.demo.controller;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
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
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.bean.User;
import com.example.demo.model.bean.Vote;
import com.example.demo.model.bean.VoteData;
import com.example.demo.model.bean.Voter;
import com.example.demo.model.bean.VoterHasVote;
import com.example.demo.model.service.UserService;
import com.example.demo.model.service.VoteDataService;
import com.example.demo.model.service.VoteService;
import com.example.demo.model.service.VoterHasVoteService;

@Controller
public class ManageController {

	@Autowired
	private VoteService voteService;
	@Autowired
	private UserService userService;
	@Autowired
	private User user;
	@Autowired
	private VoteData votedata;
	@Autowired
	private Vote vote;
	@Autowired
	private VoterHasVote voterHasVote;
	@Autowired
	private VoteDataService voteDataService;
	@Autowired
	private VoterHasVoteService voterHasVoteService;
	
	
	List vdata=new ArrayList();
	
	/**
	 * voter用户
	 * 进入votedata。html
	 * @param model
	 * @param password
	 * @param map
	 * @param session
	 * @return
	 */
	@RequestMapping(value = "votedata")
	public ModelAndView voteData(Model model, String password,HashMap<String, Object> map, HttpSession session) {

		model.addAttribute("voterhasvote",getVoteByVoteId(session));  //将getVoteByVoteId()的返回值传给votedata.html
		map.put("votedata", getVoteDataByVoteId(session));  //将getVoteDataByVoteId()的返回值传给votedata.html
		return new ModelAndView("votedata");
		
	}
	
	/**
	 * user用户
	 * 从manage.html传过来一个当前投票的id
	 * 根据id在vote表删除投票
	 * @param id
	 * @return
	 */
	@GetMapping(value = "delete")
	public String delete(int id) {
		System.out.println("delete:" + id);
		voteDataService.deleteAData(id);//想要删除vote必须先删除vote表关联外键的另一个表votedata的一条记录。
		voteService.delete(id); //调用voteService的delete()方法
		return "manage";
	}
	
//	@GetMapping(value="modify")
//	public String modify(int id) {
//		return "a";
//	}
	/**
	 * user用户
	 * 根据当前的用户名找出所有当前用户创建的投票
	 * 将找到的投票传给manage，html
	 * @param model
	 * @param session
	 * @return
	 */
//	管理界面
	@RequestMapping(value = "manage")
	@ResponseBody
	public ModelAndView manage(Model model, HttpSession session) {
		User user1 = (User) session.getAttribute("User");  //接受session
//		String name1 = user.getName();  
//		System.out.println(user1.getName());
		String name = user1.getName();
		List<Vote> vote1 = userService.selectVoteById(name);  //调用userService的selectVoteById()方法
		System.out.println(vote1);
		model.addAttribute("vote", vote1);
		return new ModelAndView("manage");
	}
	
	/**
	 * user用户
	 * 结果页面
	 * 从manage.html传过来一个当前投票的id
	 * 根据id在从vote表找到投票
	 * 将投票数据传给result.html
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("result")
	public String handleResult(int id, Model model) {
		String url = "result.html";
		System.out.println("huode id: " + id);
		Vote vote = voteService.selectVoteId(id);
		VoteData voteData = voteDataService.selectVoteId(id);
		System.out.println("firstNum:" + voteData.getFirstNum());
		model.addAttribute("vote", vote);
		model.addAttribute("votedata",voteData);
//		int a = voteData.getFirstNum();
//		int b = voteData.getSecondNum();
//		int c = voteData.getThirdNum();
//		int max=0;
//		if(a>b) {
//			if(a>c) {
//				max=a;
//			}
//		}
//		else {
//			if(b>c) {
//				max=b;
//			}
//			else {
//				max=c;
//			}
//		}
//		System.out.println("max:" + max);
		return url;
	}
	
	/**
	 * voter用户
	 * 首先根据voter的id从voterhasvote表找到所有的voteid，存进List<> vhv中
	 * 遍历vhv，得到一个个的voteid
	 * 根据voteid从vote表找到vote
	 * 通过voteid得到vote表的数据
	 * @param session
	 * @return 返回给voteData()方法
	 */
	public Object getVoteByVoteId(HttpSession session) {

		Voter voter1 = (Voter) session.getAttribute("voter");
		
		int voterid = voter1.getVoterId();
		voterHasVote.setVoterid(voterid); 

//		根据voterid查出所有voteid
		List<VoterHasVote> vhv = voterHasVoteService.selectVoteIdByVoterId(voterHasVote);
		System.out.println("aa:"+vhv);
		List temp=new ArrayList();
		for (int i = 0; i < vhv.size(); i++) { // 遍历用户名跟获取到的用户名比较,,更新votedata

			int voteid1 = vhv.get(i).getVoteid();
			System.out.println("VOTE_ID1:" + voteid1);
			Vote vote2 = voteService.selectVoteId(voteid1);
			temp.add(vote2);
			System.out.println("VOTE_IDByVoter:" + vote2);
				
		}
		return temp;
	}
	/**
	 * voter用户
	 * 首先根据voter的id从voterhasvote表找到所有的voteid，存进List<> vhv中
	 * 遍历vhv，得到一个个的voteid
	 * 根据voteid从votedata表找到vote
	 * @param session
	 * @return 返回给voteData()方法
	 */
	public Object getVoteDataByVoteId(HttpSession session) {
		Voter voter1 = (Voter) session.getAttribute("voter");
		
		int voterid = voter1.getVoterId();
		voterHasVote.setVoterid(voterid); 
		List temp2=new ArrayList();
//		根据voterid查出所有voteid
		List<VoterHasVote> vhv = voterHasVoteService.selectVoteIdByVoterId(voterHasVote); 
		for (int i = 0; i < vhv.size(); i++) { // 遍历用户名跟获取到的用户名比较,更新votedata

			int voteid1 = vhv.get(i).getVoteid();
			System.out.println("VOTE_ID1:" + voteid1);
			votedata = voteDataService.selectVoteId(voteid1);		
			temp2.add(votedata);
		}
		return temp2;
	}

}
