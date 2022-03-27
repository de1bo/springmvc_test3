package com.junefw.infra.modules.code;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeServiceImpl implements CodeService{

	@Autowired
	CodeDao dao;
	
	// infrCodeGroup
	
	// insert, update, delete
	
	@Override
	public int selectOneCount(CodeVo vo) throws Exception {
		return dao.selectOneCount(vo);
	}
	@Override
	public List<Code> selectList(CodeVo vo) throws Exception {
		return dao.selectList(vo); 
	}

	@Override
	public int insert(Code dto) throws Exception {
		// TODO Auto-generated method stub
		dao.insert(dto);		// ifcgname, ifcdname
		/* dao.insertCode(dto); */	// ifcgname, ifcdname, ifcgSeq
		return 1;
//		return dao.insert(dto);
	}
	@Override
	public Code selectOne(CodeVo vo) throws Exception {
	return dao.selectOne(vo);
	}
	
	@Override
	public int update(Code dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.update(dto);
	}
	@Override
	public int delete(CodeVo vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.delete(vo);
	}
	@Override
	public int updateDelet(CodeVo vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateDelet(vo);
	}
	
	
	/* infrCode */

	
	@Override
	public List<Code> selectListCode(CodeVo vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectListCode(vo); 
	}

	@Override
	public int insertCode(Code dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertCode(dto);
	}

	@Override
	public Code selectOneCode(CodeVo vo) throws Exception {
		// TODO Auto-generated method stub
		return dao.selectOneCode(vo);
	}

	@Override
	public int updateCode(Code dto) throws Exception {
		// TODO Auto-generated method stub
		return dao.updateCode(dto);
	}
	
	@PostConstruct
	public void selectListForCache() {
		
		List<Code> codeListFromDb = (ArrayList<Code>) dao.selectListForCache();
		
		Code.cachedCodeArrayList.clear();
		Code.cachedCodeArrayList.addAll(codeListFromDb);
		System.out.println("cachedCodeArrayList: " + Code.cachedCodeArrayList.size() + " chached ! ");
		
	}
	
	public static List<Code> selectListCachedCode(String ifcgSeq) throws Exception {
		List<Code> item = new ArrayList<Code>();
		for(Code codeRow : Code.cachedCodeArrayList) {
			if(codeRow.getIfcgSeq().equals(ifcgSeq)) {
				item.add(codeRow);
			} else {
				// by pass
			}
		}
		return item;
	}

	
	
	
	
}