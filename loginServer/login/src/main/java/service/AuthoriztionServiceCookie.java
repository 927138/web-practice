package service;

import java.util.Arrays;
import java.util.Objects;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AuthoriztionServiceCookie implements AuthoriztionService {
	
	private final HttpServletRequest req;
	private final HttpServletResponse resp;
	
	public AuthoriztionServiceCookie(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	
	@Override
	public void createAuth(String userId, String userPw) {
		if(Objects.isNull(userId))
			throw new IllegalArgumentException("cookieService.setCookie name is null");
		if(Objects.isNull(userPw))
			throw new IllegalArgumentException("cookieService.setCookie value is null");
		
		Cookie makeCookie = new Cookie(userId, "");
		makeCookie.setMaxAge(100);
		
		resp.addCookie(makeCookie);
	}
	
	@Override
	public String getdAuth(String validVariable, String id) {
		return Arrays.stream(req.getCookies())
				.filter(cookie -> cookie.getName().equals("t")) // 임시 변수
				.map(Cookie::getName)
				.findAny()
				.orElse(null);
	}
	
	@Override
	public void updateAuth(String userId, int time) {
		if(Objects.isNull(userId))
			throw new IllegalArgumentException("cookieService.setCookie name is null");
		
		Cookie makeCookie = new Cookie(userId, "test");
		makeCookie.setMaxAge(time);
		
		resp.addCookie(makeCookie);
	}
	
	@Override
	public void deleteAuth(String userId) {
		if(Objects.isNull(userId))
			throw new IllegalArgumentException("cookieService.deleteCookie name is null");
		
		// TODO
		// if: request cookie에 name 존재 하지않을 경우 로그 남기는 것에 대한 고민
		updateAuth(userId, 0);
	}
}
