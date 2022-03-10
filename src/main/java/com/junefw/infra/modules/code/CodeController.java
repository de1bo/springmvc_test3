package com.junefw.infra.modules.code;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CodeController {

	@Autowired
	CodeServiceImpl service;
	
	@RequestMapping(value = "/code/codeGroupList")
	public String codeGroupList(Model model) throws Exception {
		
		List<Code> list = service.selectList();
		model.addAttribute("list", list);
		
		return "code/codeGroupList";
	}
	@RequestMapping(value = "/code/codeGroupForm")
	public String codeGroupForm() throws  Exception{
		return "code/codeGroupForm";
	}
	
	@RequestMapping(value = "/code/codeGroupInst")
	public String codeGroupInst(Code dto) throws Exception {
		
		System.out.println();
		// 입력 실행
		service.insert(dto);
		return "redirect:/code/codeGroupList";
	}
	@RequestMapping(value = "/code/codeGroupView")
	public String codeGroupView(CodeVo vo, Model model) throws Exception{
		System.out.println("vo.getIfcgSeq"+vo.getIfcgSeq());
		
		Code item= service.selectOne(vo);
		
		model.addAttribute("item", item);
		
		return "code/codeGroupView";
	}
	@RequestMapping(value = "/code/codeGroupForm2")
	public String codeGroupForm2(CodeVo vo, Model model) throws Exception{
		
		// 한건의 데이터를 가져옴
		Code item= service.selectOne(vo);
		
		model.addAttribute("item", item);
		
		return "code/codeGroupForm2";
	}
	@RequestMapping(value = "/code/codeGroupUpdt")
	public String codeGroupUpdt(Code dto) throws Exception{
		
		
		// 수정 프로세스 실행
		service.update(dto);
		
		return "redirect:code/codeGroupView?ifcgSeq=" + dto.getIfcgSeq();
	}
	// -----------------
	// code
//	@RequestMapping(value = "/code/codeList")
//	public String codeList(Model model) throws Exception {
//		
////		List<Code> list = service.selectList();
////		model.addAttribute("list", list);
//		
//		return "code/codeList";
//	}
	
	/* infrCode */
	
	@RequestMapping(value = "/code/codeList")
	public String codeList(Model model) throws Exception {
		
		List<Code> list = service.selectListCode();
		model.addAttribute("list", list);
		
		return "code/codeList";
	}
	@RequestMapping(value = "/code/codeForm")
	public String codeForm(Model model) throws  Exception{
		
		List<Code> list = service.selectList();
		
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