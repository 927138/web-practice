package utils;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import controller.InitPageController;
import controller.JwtController;
import controller.LoginController;
import controller.MemberController;

public class ControllerStaticFactory {
	
	private final Map<String, Controller> controllers = new HashMap<>();
	
	public ControllerStaticFactory() {
		controllers.put("/member", new MemberController());
		controllers.put("/login", new LoginController());
		controllers.put("/", new InitPageController());
		controllers.put("/jwtTest", new JwtController());
	}
	
	public Controller getController(String path) {
		return controllers.get(path);
	}
	
	
}