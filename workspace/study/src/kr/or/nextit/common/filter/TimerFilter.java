/**
 * 
 */
package kr.or.nextit.common.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * urlPatterns 는 String 값으로 입력해줘도 되고, 배열로 입력 해줘도 된다.
 * @author pc36
 *
 */
@WebFilter(filterName= "TimerFilter", urlPatterns= {"/","/*"}, description="프로세스의 실행 시간 체크")
public class TimerFilter implements Filter {

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		// 메모리에서 내려갈 때
		// 대체적으로 init 설정한 자원을 정리해야 하는 경우
		System.out.println("TimerFilter destroy 메서드 호출");

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 주의 : req 타입이 ServletRequest 이므로 HttpServletRequest 로 형 변환 해서 작업 해야 할 때가 있다.
		HttpServletRequest myreq = (HttpServletRequest) req;
		
		// 전처리 부분
		long startTime = System.currentTimeMillis();
		System.out.println("TimerFilter" + myreq.getRequestURI() + ", 시작 : " + startTime );
		
		req.setAttribute("title", "넥스트 IT (Filter Test)");
		req.setAttribute("title2", "chain.doFilter 이후 테스트");
		
		// *** 포인트. 해당 프로세스의 작동 여부 관여 ***
		chain.doFilter(req, resp);
		
		
		long endTime = (System.currentTimeMillis() - startTime);
		
		// 후처리 부분
		System.out.println("TimerFilter" + myreq.getRequestURI() + ", 걸린 시간 : " + endTime);

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig config) throws ServletException {
		// 메모리에 올라올 때
		// 초기화할 자원이 있으면
		System.out.println("TimerFilter Init 메서드 호출");

	}

}
