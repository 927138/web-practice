package controller;

import java.util.Map;

import service.AuthoriztionService;
import service.CookieService;

public class LoginController implements Controller {
	
	private final AuthoriztionService authService;
	private final CookieService cookieService;
	
	public LoginController() {
		this(null, null);
	}
		
	public LoginController(AuthoriztionService authService, CookieService cookieService) {
		this.authService = authService;
		this.cookieService = cookieService;
	}
	
	
	@Override
	public String get(Map<String, String> reqParam, Map<String, Object> respParam) {
		return "/login";
	}
	
	@Override
	public String post(Map<String, String> reqParam, Map<String, Object> respParam) {
		
		String id = reqParam.get("userId");
		String pw = reqParam.get("userPw");
		
		cookieService.setCookie(id, "", 100);
		cookieService.setCookie(pw, "", 100);
		
		return "/index";
	}
	
}
