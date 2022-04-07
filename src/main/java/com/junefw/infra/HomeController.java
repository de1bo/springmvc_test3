package com.junefw.infra;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.junefw.infra.modules.member.Member;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping(value = "/sampleKakaoMap")
	public String samplekakaoMap() {

		
		return "test/map";
	}
	
	@ResponseBody //구글 로그인
	@RequestMapping(value = "/member/GloginProc")
	public Map<String, Object> GloginProc(@RequestParam("ifmmName")String name,Member dto, HttpSession httpSession) throws Exception {
		Map<String, Object> returnMap = new HashMap<String, Object>();
		
		System.out.println(name);
		httpSession.setAttribute("sessName",name);
		httpSession.setAttribute("sessId","구글 회원입니다");
		httpSession.setAttribute("sessSeq","구글 회원입니다");
		
		returnMap.put("item", "success");
		
		return returnMap;
		
		
		/*
		 * if(rtMember != null) { // rtMember = service.selectOneLogin(dto);
		 * httpSession.setAttribute("sessSeq", rtMember.getIfmmSeq());
		 * httpSession.setAttribute("sessId", rtMember.getIfmmId());
		 * httpSession.setAttribute("sessName", rtMember.getIfmmName());
		 * 
		 * returnMap.put("rt", "success"); } else { returnMap.put("rt", "fail"); }
		 * return returnMap;
		 */
		
		
	}
}
