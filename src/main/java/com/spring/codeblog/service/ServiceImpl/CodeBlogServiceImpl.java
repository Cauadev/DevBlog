package com.spring.codeblog.service.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;
import com.spring.codeblog.service.CodeBlogService;

@Service
public class CodeBlogServiceImpl  implements CodeBlogService{

	@Autowired
	CodeBlogRepository codeblogrepository;
	
	@Override
	public List<Post> findAll() {
		return codeblogrepository.findAll();
	}

	@Override
	public Post findById(int id) {
		return codeblogrepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return codeblogrepository.save(post);
	}

	@Override
	public void deleteById(int id) {
		codeblogrepository.deleteById(id);
	}

}
