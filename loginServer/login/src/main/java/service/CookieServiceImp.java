package service;

import java.util.Arrays;
import java.util.Objects;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CookieServiceImp implements CookieService {

	private final HttpServletRequest req;
	private final HttpServletResponse resp;
	
	public CookieServiceImp(HttpServletRequest req, HttpServletResponse resp) {
		this.req = req;
		this.resp = resp;
	}
	
	
	@Override
	public String getCookie(String name) {
		String resultCookie = null;
		
		Cookie[] cookies = req.getCookies();
		resultCookie = Arrays.stream(cookies)
								.filter(cookie -> cookie.getName().equals(name))
								.map(cookie -> cookie.getValue()) // Cookie::getValue
								.findFirst()
								.orElse(null);
		
		return resultCookie;
	}
	
	@Override
	public void setCookie(String name, String value, int maxAge) {
		
		if(Objects.isNull(name))
			throw new IllegalArgumentException("cookieService.setCookie name is null");
		if(Objects.isNull(value))
			throw new IllegalArgumentException("cookieService.setCookie value is null");
		
		Cookie makeCookie = new Cookie(name, value);
		makeCookie.setMaxAge(maxAge);
		
		resp.addCookie(makeCookie);
	}
	
	@Override
	public void deleteCookie(String name) {
		if(Objects.isNull(name))
			throw new IllegalArgumentException("cookieService.deleteCookie name is null");
		
		// TODO
		// if: request cookie에 name 존재 하지않을 경우 로그 남기는 것에 대한 고민
		setCookie(name, "", 0);
	}
}
