package com.gl.market.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.market.model.UserCopVo;
import com.gl.market.model.UserJoinVo;
import com.gl.market.model.UserMypageDao;

@Controller
public class UserMyCon {
	
	@Autowired
	private SqlSession sqlSession;
	HttpSession session;
	
	@RequestMapping("/mylist")
	public String myPage(){
		return "mypage/mylist";
	}
	
	@RequestMapping("/julist")
	public String juList(){
		return "mypage/julist";
	}
	
	@RequestMapping("/coplist")
	public String copList(Model model, HttpServletRequest req){
		session = req.getSession();
		String id = (String)session.getAttribute("id");
		UserMypageDao mapper = sqlSession.getMapper(UserMypageDao.class);
		List<UserCopVo> list = mapper.copList(id);
		System.out.println(list.get(0));
		model.addAttribute("coplist", list);
		return "mypage/coplist";
	}
	
	@RequestMapping("/cashcheck")
	public void cashCheck(@RequestParam("id")String id, HttpServletResponse resp){
		UserMypageDao mapper = sqlSession.getMapper(UserMypageDao.class);
		UserJoinVo mile = mapper.mileCk(id); 
		try {
			PrintWriter out = resp.getWriter();
			out.print(mile.getCash());
		} catch (IOException e) {
			System.out.println("프린트 오류");
		}
	}
	@RequestMapping("/copcheck")
	public void copCheck(@RequestParam("id")String id, HttpServletResponse resp){
		UserMypageDao mapper = sqlSession.getMapper(UserMypageDao.class);
		int cop = mapper.copCk(id);
		try {
			PrintWriter out = resp.getWriter();
			out.print(cop);
		} catch (IOException e) {
			System.out.println("프린트 오류");
		}
	}
	
	@RequestMapping("/editform")
	public String editForm(HttpServletRequest req){
		session = req.getSession();
		String id = (String) session.getAttribute("id");
		UserMypageDao mapper = sqlSession.getMapper(UserMypageDao.class);
		UserJoinVo bean = mapper.userOne(id);
		req.setAttribute("bean", bean);
		return "mypage/myedit";
	}
	
}
