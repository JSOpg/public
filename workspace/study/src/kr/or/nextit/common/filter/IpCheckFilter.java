package kr.or.nextit.common.filter;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.nextit.function.service.ComCodeService;
import kr.or.nextit.function.service.CommCodeVo;
import kr.or.nextit.function.service.impl.ComCodeServiceImpl;
import kr.or.nextit.login.service.LoginVo;

@WebFilter(filterName="IpCheckFilter", urlPatterns= {"/test123/*"})
// @WebFilter(filterName="IpCheckFilter", urlPatterns= {"/*"})
public class IpCheckFilter implements Filter {
	
	private Map<String, String> ipMap;
	private ComCodeService codeService;
	private List<CommCodeVo> ipList = null;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		ipMap = null;

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		// HttpServletRequest myreq = (HttpServletRequest) req;
		// HttpServletResponse myresp = (HttpServletResponse) resp;
		
		/*
		HttpServletRequest request = (HttpServletRequest) req;
		HttpSession session = request.getSession();
		
		
		LoginVo loginInfo = (LoginVo) session.getAttribute("loginInfo");
		
		if(loginInfo != null) {
			// 로그인 성공
			chain.doFilter(req, resp);
		} else {
			// 로그인 실패
			RequestDispatcher dispatcher = req.getRequestDispatcher("/13/loginForm.jsp");
			dispatcher.forward(req, resp);
		}
		*/
		
		// 32진수 IPv4 : 127.0.0.1, 129.168.10.2
		// 128진수 IPv6 : localhost = ...
		String ip = req.getRemoteAddr();
		
		// 접근 승인 여부
		try {
			
			CommCodeVo resultCodeVo = codeService.getIpItem(ip);
			
			if(ip != null && resultCodeVo != null && ip.equals(resultCodeVo.getKey()) && "A".equals(resultCodeVo.getValue())) {
				
				chain.doFilter(req, resp);
				
			} else {
				throw new Exception(
						String.format("' %s ' 사용자는 접근 금지", ip)
						);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
			resp.setCharacterEncoding("UTF-8");
			resp.setContentType("text/html");
			RequestDispatcher dispatcher = req.getRequestDispatcher("/Deny.jsp");
			dispatcher.forward(req, resp);
		}
		
		
		/*
		if (ip != null && ipMap.containsKey(ip)) {
			// 존재하는 IP(Access / Deny)
			if ("A".equals(ipMap.get(ip))) { // 허용
				System.out.println("존재하는 IP 승인 ======");
				chain.doFilter(req, resp);
				
			} else { // 거부

				System.out.println("존재하지 않는 IP 거부 ======");
				resp.setCharacterEncoding("UTF-8");
				resp.setContentType("text/html");
				RequestDispatcher dispatcher = req.getRequestDispatcher("/Deny.jsp");
				dispatcher.forward(req, resp);
			}

		} else {
			// 존재하지 않는 IP
			// sendRedirect, forward
			System.out.println("존재하지 않는 IP index.jsp ======");
			RequestDispatcher dispatcher = myreq.getRequestDispatcher("/Deny.jsp");
			dispatcher.forward(req, resp);
		}
		*/
		
	}
	
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
		try {
			codeService = new ComCodeServiceImpl();
			ipList = codeService.getIpList();
			
			for(CommCodeVo commCodeVo : ipList) {
				System.out.println(String.format("IP Key = %s / 승인 여부 = %s", commCodeVo.getKey(), commCodeVo.getValue()));
			}
			
		} catch (Exception e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*
		ipMap = new HashMap<>();
		ipMap.put("127.0.0.1", "A");
		ipMap.put("192.168.10.2", "A");
		ipMap.put("192.168.10.22", "A");
		ipMap.put("192.168.10.20", "A");
		ipMap.put("192.168.10.13", "A");
		
		System.out.println("ipMap data Init() 등록된 IP 확인 ======");
		
		
		Set<String> ipKey = ipMap.keySet();
		
		
		for(String key : ipKey) {
			System.out.println(String.format("IP Key = %s / 승인 여부 = %s", key, ipMap.get(key)));
		}
		*/
	}

}