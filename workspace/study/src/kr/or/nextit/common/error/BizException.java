package kr.or.nextit.common.error;

public class BizException extends Exception {
	
	public BizException () {
		super("비지니스 로직을 구현하는 과정에서 에러가 발생 했습니다.");
	}
	
	public BizException(String message) {
		super(message);
	}
	
	public BizException(String message, Throwable ex) {
		super(message, ex);
	}
}
