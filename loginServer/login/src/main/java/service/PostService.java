package service;

import java.util.List;

import model.CreatePostRequest;
import model.PostRequest;

public interface PostService {
	List<PostRequest> getPostList();
	void writePost(CreatePostRequest post);
}
