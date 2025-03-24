package controller;

import java.util.List;
import java.util.Map;

import DTO.PostDTO;
import service.PostService;

public class PostController implements Controller{
	
	private final PostService postService;
	
	public PostController(PostService postService) {
		this.postService = postService;
	}

	@Override
	public String get(Map<String, Object> reqParam, Map<String, Object> respParam) {
		reqParam.put("posts", postService.getPostList());
		return "/posts";
	}
	
	@Override
	public String post(Map<String, Object> reqParam, Map<String, Object> respParam) {
		
		return "";
	}
}
