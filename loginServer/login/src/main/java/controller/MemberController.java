package controller;

import java.util.Map;

import common.Controller;

public class MemberController implements Controller {

	@Override
	public String get(Map<String, String> param, Map<String, Object> model) {
		return "/member";
	}
	
	
	@Override
	public String post(Map<String, String> param, Map<String, Object> model) {
		// TODO Auto-generated method stub
		return Controller.super.post(param, model);
	}
	
}
