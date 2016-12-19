package com.gl.market.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
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
	
	@RequestMapping("/outform")
	public String outForm(){
		return "mypage/outform";
	}
	
	@RequestMapping("/coplist")
	public String copList(@RequestParam("idx")int idx ,Model model, HttpServletRequest req){
		session = req.getSession();
		int p=idx;
		int row = 5;
		int rowTot=1;
		int stert = (p-1)*row+1;
		int end = stert+(row-1);
		String id = (String)session.getAttribute("id");
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("id", id);
		map.put("stert", stert);
		map.put("end", end);
		System.out.println(map.get("id")+":"+map.get("stert")+":"+map.get("end"));
		UserMypageDao mapper = sqlSession.getMapper(UserMypageDao.class);
		rowTot = mapper.copCk(id);
		List<UserCopVo> list = mapper.copList(map);
		int pTot = (rowTot-1)/row+1;
		
		model.addAttribute("pTot", pTot);
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
	
	@RequestMapping("/pwcheck")
	public void pwCheck(@RequestParam("id")String id, HttpServletResponse resp){
		UserMypageDao mapper = sqlSession.getMapper(UserMypageDao.class);
		UserJoinVo bean = mapper.userOne(id); 
		try {
			PrintWriter out = resp.getWriter();
			out.print(bean.getPw());
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
	
	@RequestMapping("/edit")
	public String edit(UserJoinVo bean,HttpServletRequest req){
		session = req.getSession();
		String id = (String) session.getAttribute("id");
		UserMypageDao mapper = sqlSession.getMapper(UserMypageDao.class);
		mapper.userUpdata(bean);
		return "redirect:./editform";
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest req){
		session = req.getSession();
		String id = (String) session.getAttribute("id");
		UserMypageDao mapper = sqlSession.getMapper(UserMypageDao.class);
		mapper.userDelete(id);
		session.invalidate();
		return "redirect:/";
	}
	
}
