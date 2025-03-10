package controller;

import java.util.Map;

public class MemberController implements Controller {

	@Override
	public String get(Map<String, String> reqParam, Map<String, Object> respParam) {
		return "/member";
	}
	
	
	@Override
	public String post(Map<String, String> reqParam, Map<String, Object> respParam) {
		// TODO Auto-generated method stub
		return Controller.super.post(reqParam, respParam);
	}
	
}
