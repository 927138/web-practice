package controller;

import java.util.Map;

import common.Controller;

public class InitPageController implements Controller {
	
	@Override
	public String get(Map<String, String> getParam, Map<String, Object> setParam) {
		return "/index";
	}

}
