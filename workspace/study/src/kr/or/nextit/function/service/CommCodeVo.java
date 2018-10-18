package kr.or.nextit.function.service;

import java.io.Serializable;

public class CommCodeVo implements Serializable {

	private String key;
	private String value;

	public CommCodeVo() {
		// 빈 인스턴스 생성
	}
	
	public CommCodeVo(String key, String value){
		// key, value 값을 입력받아 인스턴스 생성
		this.key = key;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

}
