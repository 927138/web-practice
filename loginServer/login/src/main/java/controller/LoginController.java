package controller;

import java.util.Map;

import common.Controller;

public class LoginController implements Controller {
	
	
	@Override
	public String get(Map<String, String> param, Map<String, Object> model) {
		return "/login";
	}
	
	@Override
	public String post(Map<String, String> param, Map<String, Object> model) {
		
		String id = param.get("userId");
		String pw = param.get("userPw");
		
		if(param.get("storage").equals(id)) {
			System.out.println("good");
		}
		
		return "/index";
	}
	
}
