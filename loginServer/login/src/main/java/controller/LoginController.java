package controller;

import java.util.Map;
import java.util.Objects;

import service.AuthoriztionService;
import service.CookieService;

public class LoginController implements Controller {
	
	private final AuthoriztionService authService;
	
	public LoginController() {
		this(null);
	}
		
	public LoginController(AuthoriztionService authService) {
		this.authService = authService;
	}
	
	
	@Override
	public String get(Map<String, String> reqParam, Map<String, Object> respParam) {
		return "/login";
	}
	
	@Override
	public String post(Map<String, String> reqParam, Map<String, Object> respParam) {
		
		String id = reqParam.get("userId");
		String pw = reqParam.get("userPw");
		
		String cookieData = authService.getdAuth(id, id);
		if(!Objects.isNull(cookieData)) {
			System.out.println("cookie exist");
			authService.deleteAuth(id);
			return "/index";
		}
		
		
		authService.createAuth(id, pw);
		System.out.println("cookie existsdfsdfsdf");
		
		return "/index";
	}
	
}
