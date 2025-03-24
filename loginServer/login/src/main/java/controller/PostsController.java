package controller;

import java.util.Map;

import service.PostService;

public class PostsController implements Controller{
	
	private final PostService postService;
	
	public PostsController(PostService postService) {
		this.postService = postService;
	}

	@Override
	public String get(Map<String, Object> reqParam, Map<String, Object> respParam) {
		reqParam.put("posts", postService.getPostList());
		return "/posts";
	}

}
