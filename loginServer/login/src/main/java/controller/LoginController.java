package controller;

import java.util.Map;

import common.Controller;
import service.AuthoriztionService;
import service.CookieService;

public class LoginController implements Controller {
	
	private final AuthoriztionService authService;
	private final CookieService cookieService;
	
	public LoginController(AuthoriztionService authService) {
		this(authService, null);
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
		
		if(reqParam.get("storage").equals(id)) {
			System.out.println("good");
		}
		
		return "/index";
	}
	
}
