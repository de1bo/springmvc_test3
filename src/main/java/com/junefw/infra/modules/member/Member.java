package com.junefw.infra.modules.member;

public class Member {
	private String seq="";
	private String ifmmId="";
	private String ifmmName="";
	private Integer DelNy;
	
	
	// ------------------
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getIfmmId() {
		return ifmmId;
	}
	
	public void setIfmmId(String ifmmId) {
		this.ifmmId = ifmmId;
	}
	public String getIfmmName() {
		return ifmmName;
	}
	public void setIfmmName(String ifmmName) {
		this.ifmmName = ifmmName;
	}
	
	public Integer getIfmmDelNy() {
		return DelNy;
	}
	public void setIfmmDelNy(Integer ifmmDelNy) {
		this.DelNy = DelNy;
	}
	
}
