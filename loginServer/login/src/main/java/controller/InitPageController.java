package controller;

import java.util.Map;

public class InitPageController implements Controller {
	
	@Override
	public String get(Map<String, String> reqParam, Map<String, Object> respParam) {
		return "/index";
	}

}
