package com.spring.codeblog.utils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

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
		codeblogrepo.deleteById(9);
		codeblogrepo.deleteById(10);
	}

}
