package service;

import java.util.List;

import DTO.PostDTO;

public interface PostService {
	List<PostDTO> getPostList();
	void writePost(PostDTO post);
}
