package utils;

import java.util.HashMap;
import java.util.Map;

import controller.InitPageController;
import controller.PostController;
import controller.PostsController;
import jakarta.servlet.ServletContext;
import repository.PostRepository;
import service.PostService;
import service.PostServiceImp;

public class DependencyFactory {
	
	private final Map<String, Object> objectContainer = new HashMap<>();
	
	public DependencyFactory(ServletContext context) {
		injectionContextConfig(context);
		injectionRepostiory();
		injectionService();
		injectionController();
	}
	
	public Object getController(String path) {
		return objectContainer.get(path);
	}
	
	private void injectionContextConfig(ServletContext context) {
		this.objectContainer.put("MysqlConfigration", new MysqlConfigration(context));
	}
	
	private void injectionRepostiory() {
		this.objectContainer.put("PostRepository", 
				new PostRepository((MysqlConfigration) objectContainer.get("MysqlConfigration")));
	}
	
	private void injectionService() {
		this.objectContainer.put("PostService", 
				new PostServiceImp((PostRepository) objectContainer.get("PostRepository")));
	}
	
	private void injectionController() {
		this.objectContainer.put("/", new InitPageController());
		this.objectContainer.put("/posts", 
				new PostsController((PostService) objectContainer.get("PostService")));
		this.objectContainer.put("/write", 
				new PostController((PostService) objectContainer.get("PostService")));
	}
}