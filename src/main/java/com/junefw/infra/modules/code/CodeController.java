package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CodeController {



	@Autowired
	CodeServiceImpl service;
	
	@RequestMapping(value = "/code/codeGroupList")
	public String codeGroupList(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception {
		
		// count 가져올 것
		int count = service.selectOneCount(vo);
		
		vo.setParamsPaging(count);
		
		if(count != 0) {
			List<Code> list = service.selectList(vo);
			model.addAttribute("list", list);
		} else {
			// by pass
		}
		// count 가 0이 아니면 list 가져오는 부분 수정 후 model 개체에 담기
		/* model.addAttribute("vo", vo); */
		return "code/codeGroupList";
	}
	
	
	@RequestMapping(value = "/code/codeGroupForm")
	public String codeGroupForm(@ModelAttribute("vo") CodeVo vo) throws  Exception{
		
		return "code/codeGroupForm";
	}
	
	@RequestMapping(value = "/code/codeGroupInst")
	public String codeGroupInst(CodeVo vo, Code dto, RedirectAttributes redirectAttributes) throws Exception {
		
		System.out.println();
		// 입력 실행
		service.insert(dto);
		System.out.println("dto.getIfcgSeq()" + dto.getIfcgSeq());
		
		redirectAttributes.addAttribute("ifcgSeq", dto.getIfcgSeq());
		redirectAttributes.addAttribute("thisPage", vo.getThisPage());
		redirectAttributes.addAttribute("shOption", vo.getShOption());
		redirectAttributes.addAttribute("shValue", vo.getShValue());
		
		
		return "redirect:/code/codeGroupView";
//		 return "redirect:/code/codeGroupView?ifcgSeq="+ dto.getIfcgSeq() + makeQueryString(vo);
//		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() +"&thisPage=" + vo.getThisPage() + "&shOption=" + vo.getShOption() + "&shValue=" + vo.getShValue();
	}
	
//	public String makeQueryString(CodeVo vo) {
//		String tmp= "&thisPage" + vo.getThisPage()
//					+ "&shOption=" + vo.getShOption()
//					+ "&shValue=" + vo.getShValue();
//		return tmp;
//	}
	
	@RequestMapping(value = "/code/codeGroupView")
	public String codeGroupView(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception{
		System.out.println("vo.getIfcgSeq"+vo.getIfcgSeq());
		
		// db까지 가서 한 건의 데이터 값을 가지고 옴 vo
		Code item= service.selectOne(vo);
		
		model.addAttribute("item", item);
		
		return "code/codeGroupView";
	}
	@RequestMapping(value = "/code/codeGroupForm2")
	public String codeGroupForm2(@ModelAttribute("vo") CodeVo vo, Model model) throws Exception{
		
		// 한건의 데이터를 가져옴
		Code item= service.selectOne(vo);
		
		model.addAttribute("item", item);
		
		return "code/codeGroupForm2";
	}
	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(@ModelAttribute("vo") CodeVo vo, Code dto, RedirectAttributes redirectAttributes) throws Exception{
		
		
		// 수정 프로세스 실행
		service.update(dto);
		
		
		redirectAttributes.addAttribute("ifcgSeq", dto.getIfcgSeq());
		redirectAttributes.addAttribute("thisPage", vo.getThisPage());
		redirectAttributes.addAttribute("shOption", vo.getShOption());
		redirectAttributes.addAttribute("shValue", vo.getShValue());
		
		return "redirect:/code/codeGroupView";
//		 return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() + makeQueryString(vo); 
//		return "redirect:/code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq() +"&thisPage=" + vo.getThisPage() + "&shOption=" + vo.getShOption() + "&shValue=" + vo.getShValue();
	}
	
	/* infrCode */
	
	@RequestMapping(value = "/code/codeList")
	public String codeList(CodeVo vo,Model model) throws Exception {
		
		List<Code> list = service.selectListCode(vo);
		model.addAttribute("list", list);
		List<Code> listCodeGroup = service.selectList(vo);
		model.addAttribute("listCodeGroup", listCodeGroup);
		
		return "code/codeList";
	}
	@RequestMapping(value = "/code/codeForm")
	public String codeForm(CodeVo vo,Model model) throws  Exception{
		
		List<Code> list = service.selectListCode(vo);
		
		model.addAttribute("list", list);
		
		return "code/codeForm";
	}
	
	@RequestMapping(value = "/code/codeInst")
	public String codeInst(Code dto) throws Exception {
		
		service.insertCode(dto);

		return "redirect:/code/codeList";
	}
	@RequestMapping(value = "/code/codeView")
	public String codeView(CodeVo vo, Model model) throws Exception{
		System.out.println("vo.getIfcgSeq"+vo.getIfcgSeq());
		
		Code item= service.selectOneCode(vo);
		
		model.addAttribute("item2", item);
		
		return "code/codeView";
	}
	@RequestMapping(value = "/code/codeForm2")
	public String codeForm2(CodeVo vo, Model model) throws Exception{
		
		// 한건의 데이터를 가져옴
		Code item= service.selectOneCode(vo);
		
		model.addAttribute("item2", item);
		
		return "code/codeForm2";
	}
	@RequestMapping(value = "/code/codeUpdt")
	public String codeUpdt(Code dto) throws Exception{
		
		
		// 수정 프로세스 실행
		service.updateCode(dto);
		
		return "";
	}
}