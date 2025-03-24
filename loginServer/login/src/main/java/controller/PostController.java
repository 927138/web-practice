package controller;

import java.util.Map;

import model.CreatePostRequest;
import service.PostService;

public class PostController implements Controller {
	
	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}
	
	@Override
	public String get(Map<String, Object> reqParam, Map<String, Object> respParam) {
		return "/write";
	}
	
	@Override
	public String post(Map<String, Object> reqParam, Map<String, Object> respParam) {
		String name = (String) reqParam.get("name");
		String title = (String) reqParam.get("title");
		String content = (String) reqParam.get("content");
		
		CreatePostRequest data = CreatePostRequest.builder()
										.name(name)
										.title(title)
										.content(content)
										.build();
		
		postService.writePost(data);
		return "redirect:/loginAPI/posts";
	}
}
