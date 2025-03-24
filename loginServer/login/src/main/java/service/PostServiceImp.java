package service;

import java.util.List;

import DTO.PostDTO;
import repository.PostRepository;

public class PostServiceImp implements PostService{
	private final PostRepository postRepository;
	
	public PostServiceImp(PostRepository postRepository) {
		this.postRepository = postRepository;
	}
	
	@Override
	public List<PostDTO> getPostList() {
		List<PostDTO> postList = postRepository.selectListPage();
		return postList;
	}
	
	@Override
	public void writePost(PostDTO post) {
		postRepository.writeBoard(post);
	}
}
