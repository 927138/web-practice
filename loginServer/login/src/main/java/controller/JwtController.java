package controller;

import java.util.Map;
import java.util.Objects;

import utils.JwtManager;

public class JwtController implements Controller {
	
	
	@Override
	public String get(Map<String, String> reqParam, Map<String, Object> respParam) {
		
		JwtManager manager = new JwtManager();
		String token = "";

		System.out.println(Objects.isNull(reqParam.get("token")));
		
		System.out.println("--------------------------");
		reqParam.keySet().forEach(System.out::println);
		System.out.println("--------------------------");
		
		
		if(Objects.isNull(reqParam.get("token"))) {
			token = manager.generateJwtToken();
			respParam.put("token", token);
			respParam.put("cookie", "t");
		}else {
			token = manager.getTestValueToGetTest(token);
			System.out.println(manager.getTestValueToGetTest(token));
		}
		
		
		
		System.out.println(token);
		
		return "/index";
	}
	
}
