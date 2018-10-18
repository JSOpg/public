package kr.or.nextit.review.service;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ReViewVo implements Serializable {

	private String code;
	private String name;
	
	public ReViewVo() {
		
	}
	
	public ReViewVo(String code, String name) {
		this.code = code;
		this.name = name;
	}
	
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
