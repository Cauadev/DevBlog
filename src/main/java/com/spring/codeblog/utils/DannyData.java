package com.spring.codeblog.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;

@Component
public class DannyData {

	@Autowired
	CodeBlogRepository codeblogrepo;

//	@PostConstruct
	public void savePosts() {
		Post post = codeblogrepo.findById(18).get();
		post.addView();
	}

}
