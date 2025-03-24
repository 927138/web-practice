package utils;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import controller.InitPageController;

public class ControllerStaticFactory {
	
	private final Map<String, Controller> controllers = new HashMap<>();
	
	public ControllerStaticFactory() {
		controllers.put("/", new InitPageController());
	}
	
	public Controller getController(String path) {
		return controllers.get(path);
	}
	
	
}