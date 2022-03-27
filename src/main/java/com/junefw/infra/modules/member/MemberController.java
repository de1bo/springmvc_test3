package com.junefw.infra.modules.member;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MemberController {

	@Autowired
	MemberServiceImpl service;
	
	@RequestMapping(value = "/member/memberList")
//	public String memberList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {
	public String memberList(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception {

//		int count = service.selectOneCount(vo);
//		vo.setParamsPaging(count);
//		
//		if(count != 0) {
//			List<Member> list = service.selectList(vo);
//			model.addAttribute("list", list);
//		} else {
//			// by pass
//		}
		

		return "member/memberList";
	}
	
	@RequestMapping(value = "/member/memberForm")
	public String memberForm(@ModelAttribute("vo") Model model, MemberVo vo) throws Exception {

//		if(vo.getSeq().equals("0")) {
//			
//		} else {
//			Member item = service.selectOne(vo);
//			model.addAttribute("item", item);
//		}
		
		/*
		 * model.addAttribute("MemberGender",
		 * MemberServiceImpl.selectListCachedCode("3"));
		 * model.addAttribute("MemberTelecom",
		 * MemberServiceImpl.selectListCachedCode("10"));
		 */
		
		return "member/memberForm";
	}
	
	
	@RequestMapping(value = "/member/memberInst")
	public String memberInst(Model model, Member dto) throws Exception {
		
		System.out.println("dto.getIfmmName(): " + dto.getIfmmName());

		// 입력을 작동시킨다.
		int result = service.insert(dto);
		
		System.out.println("result: " + result);

		return "redirect:/member/memberList";
	}

	/*---------------------------------*/
	@RequestMapping(value = "/member/memberView")
	public String MemberView(MemberVo vo, Model model) throws Exception{
		System.out.println("vo.getSeq"+vo.getSeq());
		
		Member item= service.selectOne(vo);
		
		model.addAttribute("item", item);
		
		return "member/memberView";
	}
	@RequestMapping(value = "/member/memberForm2")
	public String MemberForm2(@ModelAttribute("vo") MemberVo vo, Model model) throws Exception{
		
		// 한건의 데이터를 가져옴
		Member item= service.selectOne(vo);
		
		model.addAttribute("item", item);
		
		return "member/memberForm2";
	}
	@RequestMapping(value = "/member/memberUpdt")
	public String memberUpdt(@ModelAttribute("vo") Member dto, MemberVo vo, RedirectAttributes redirectAttributes) throws Exception{
		
		
		// 수정 프로세스 실행
		service.update(dto);
		
		
		return "member/memberView";
	}
}