package kr.or.nextit.servlet;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.nextit.common.web.IController;

@WebServlet(name="comBoardServlet", urlPatterns= {"*.do"})
public class ComBoardServlet extends HttpServlet {
	
	private Map<String, IController> controllMap = new HashMap<>();
	
	@Override
	public void init() throws ServletException {
		System.out.println("ComBoardServlet.init()");
		
		// 클래스 패스에서 프로퍼티 파일 검색
		ResourceBundle bundle = ResourceBundle.getBundle("ComBoardMapper");
		
		// resource File (*.properties)
		Enumeration<String> keys = bundle.getKeys();
		
		// 가지고 온 키 값의 목록의 갯수만큼 반복(EOF 까지)
		while(keys.hasMoreElements()) {
			// trim() : 빈 공간이 있으면 제거(띄어 쓰기)
			String key = keys.nextElement().trim();
			// key 값의 value에 해당하는 값을 가지고 온다.
			String value = bundle.getString(key).trim();
			
			try { // 객체 인스턴스를 생성할 때 에러가 발생할 경우 에러 처리를 한다.
				
				// class.forName 으로 인터페이스에 해당하는 객체(class) 를 찾아서 인스턴스를 생성한다.
				IController controller = (IController) Class.forName(value).newInstance();
				
				// controllMap 객체에 등록(map.put key,생성된 인스턴스 객체)
				controllMap.put(key,controller);
				
				System.out.printf("%s의 컨트롤 %s 등록",key,value);
			} catch(ClassNotFoundException | InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
				throw new ServletException();
			}
		}
		
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		try {
			// 사용자의 요청을 분석(URI)
			String uri = req.getRequestURI();
			System.out.printf("사용자 요청 URI : %s",uri);
			
			// was contextPath를 제거 해줌.
			uri = uri.substring(req.getContextPath().length());
			System.out.printf("변경된 URI : %s",uri);
			
			Set<String> keys = controllMap.keySet();
			
			// properties 파일에서 uri에 요청된 값이 등록 돼 있는 지 판별하여 true/false 값 반환
			if(controllMap.containsKey(uri)) {
				// map 객체에 등록된 키 값으로 해당하는 인스턴스를 가지고 온다.
				IController controller = controllMap.get(uri);
				String viewPage = controller.process(req, resp);
				
				if(controller.isRedirect()) {
					resp.sendRedirect(viewPage);
				} else {
					RequestDispatcher dispatcher = req.getRequestDispatcher(String.format("/WEB-INF/view%s.jsp", viewPage));
					dispatcher.forward(req, resp);					
				}
				
				
			} else {
				// 요청에 대한 컨트롤러가 없는 경우, 404 에러
				resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
			}
			
			/*
			for (String key : keys) {
				System.out.printf("key : %s\n",key);
				if(uri.equals(key)) {
					
					IController controller = controllMap.get(key);
					controller.process(req, resp);					
				} else {
					// resp.setStatus(HttpServletResponse.SC_NOT_FOUND); // 404
				}
			}
			*/
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}