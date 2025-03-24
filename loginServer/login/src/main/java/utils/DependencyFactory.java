package utils;

import java.util.HashMap;
import java.util.Map;

import controller.Controller;
import controller.InitPageController;
import jakarta.servlet.ServletContext;
import repository.MysqlConfigration;

public class DependencyFactory {
	
	private final Map<String, Object> objectContainer = new HashMap<>();
	
	public DependencyFactory(ServletContext context) {
		contextConfig(context);
		controllerInjection();
	}
	
	public Object getController(String path) {
		return objectContainer.get(path);
	}
	
	private void contextConfig(ServletContext context) {
		this.objectContainer.put("mysql", new MysqlConfigration(context));
	}
	
	private void controllerInjection() {
		this.objectContainer.put("/", new InitPageController());
	}
}