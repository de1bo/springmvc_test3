package com.junefw.infra.modules.code;

import java.util.ArrayList;
import java.util.List;

public class Code {
	
	private String ifcgSeq;
	private String ifcgName;
	private String ifcgeEng;
	private Integer delNy;
	
	private String ifcdSeq;
	private String ifcdName;
	private String ifcdDelNy;
	private String infrCodeGroup_ifcgSeq;
//	private String ifcgSeq;
	
	static List<Code> cachedCodeArrayList = new ArrayList<Code>();
	
	// --------------------
	public String getIfcgSeq() {
		return ifcgSeq;
	}
	public void setIfcgSeq(String ifcgSeq) {
		this.ifcgSeq = ifcgSeq;
	}
	public String getIfcgName() {
		return ifcgName;
	}
	public void setIfcgName(String ifcgName) {
		this.ifcgName = ifcgName;
	}
	public String getIfcgeEng() {
		return ifcgeEng;
	}
	public void setIfcgeEng(String ifcgeEng) {
		this.ifcgeEng = ifcgeEng;
	}
	public Integer getDelNy() {
		return delNy;
	}
	public void setDelNy(Integer delNy) {
		this.delNy = delNy;
	}
	public String getIfcdSeq() {
		return ifcdSeq;
	}
	public void setIfcdSeq(String ifcdSeq) {
		this.ifcdSeq = ifcdSeq;
	}
	public String getIfcdName() {
		return ifcdName;
	}
	public void setIfcdName(String ifcdName) {
		this.ifcdName = ifcdName;
	}
	public String getIfcdDelNy() {
		return ifcdDelNy;
	}
	public void setIfcdDelNy(String ifcdDelNy) {
		this.ifcdDelNy = ifcdDelNy;
	}
	public String getInfrCodeGroup_ifcgSeq() {
		return infrCodeGroup_ifcgSeq;
	}
	public void setInfrCodeGroup_ifcgSeq(String infrCodeGroup_ifcgSeq) {
		this.infrCodeGroup_ifcgSeq = infrCodeGroup_ifcgSeq;
	}
	
	
	

}
