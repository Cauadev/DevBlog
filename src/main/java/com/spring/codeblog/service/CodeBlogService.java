package com.spring.codeblog.service;

import java.util.List;

import com.spring.codeblog.model.Post;

public interface CodeBlogService {
	
	List<Post> findAll();
	
	Post findById(int id);
	
	Post save(Post post);
	
	void deleteById(int id);
	
	void update(Post post);
	
	List<Post> getAllPosts();
	
}
