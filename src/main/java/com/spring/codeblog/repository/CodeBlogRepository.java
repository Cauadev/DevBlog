package com.spring.codeblog.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.codeblog.model.Post;

@Repository
@Transactional
public interface CodeBlogRepository extends JpaRepository<Post, Integer>{

	@Query("SELECT p FROM Post p ORDER BY p.views desc")
	List<Post> getPosts();
}
