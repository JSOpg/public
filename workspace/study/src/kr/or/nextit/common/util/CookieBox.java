package kr.or.nextit.common.util;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class CookieBox {
	
	private Map<String, Cookie> cookieMap = new HashMap<String,Cookie>();
	// private HashMap<String, Cookie> cookieMap = new HashMap<String,Cookie>();
	
	private static String charType = "UTF-8";
	
	/**
	 * 쿠키(Cookie) request 객체에서 가지고 와서 cookieMap(Map) 객체에 주입
	 * @param request
	 */
	public CookieBox(HttpServletRequest request) {
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				// 생성된 쿠키 이름과 쿠키(Object) 값을 Map 객체에 주입.
				cookieMap.put(cookie.getName(), cookie);
			}
		}
	}
	
	/**
	 * cookieMap (map) 객체에서 name에 해당하는 값을 Cookie 값으로 반환
	 * @param name
	 * @return
	 */
	public Cookie getCookie(String name) {
		return cookieMap.get(name);
	}
	
	/**
	 * 쿠키에 들어 있는 값을 URLDecoder.decode() 메서드로 값 반환
	 * @param name
	 * @return
	 * @throws IOException
	 */
	
	public String getValue(String name) throws IOException {
		Cookie cookie = cookieMap.get(name);
		if(cookie == null) {
			return null;
		}
		return URLDecoder.decode(cookie.getValue(), charType); // system win -> EUC-kr
	}
	
	/**
	 * 등록된 쿠키명이 있는지 없는지 확인(true/false)
	 * @param name
	 * @return
	 */
	public boolean exists(String name) {
		return cookieMap.containsKey(name);
	}
	
	/**
	 * 쿠키 생성시 기본 설정 생성될 쿠키명과 값(value)
	 * @param name
	 * @param value
	 * @return
	 * @throws IOException
	 */
	public static Cookie createCookie(String name, String value) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, charType));
		cookie.setPath("/");
		return cookie;
	}
	
	/**
	 * @param name
	 * @param value
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public static Cookie createCookie(String name, String value, String path) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, charType));
		cookie.setPath(path);
		return cookie;
	}
	
	/**
	 * @param name
	 * @param value
	 * @param path
	 * @param maxAge
	 * @return
	 * @throws IOException
	 */
	public static Cookie createCookie(String name, String value, String path, int maxAge) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, charType));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		return cookie;
	}
	
	/**
	 * @param name
	 * @param value
	 * @param path
	 * @param maxAge
	 * @param domain
	 * @return
	 * @throws IOException
	 */
	public static Cookie createCookie(String name, String value, String path, int maxAge, String domain) throws IOException {
		Cookie cookie = new Cookie(name, URLEncoder.encode(value, charType));
		cookie.setPath(path);
		cookie.setMaxAge(maxAge);
		cookie.setDomain(domain);
		return cookie;
	}
}