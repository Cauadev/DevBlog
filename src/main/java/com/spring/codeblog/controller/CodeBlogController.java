package com.spring.codeblog.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.codeblog.model.Post;
import com.spring.codeblog.repository.CodeBlogRepository;
import com.spring.codeblog.service.CodeBlogService;

@Controller
public class CodeBlogController {
	
	@Autowired
	CodeBlogService codeblogservice;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts(){
	  ModelAndView mv = new ModelAndView("posts");
	  List<Post> posts = codeblogservice.findAll();
	  mv.addObject("posts", posts);
	  return mv;
	 }
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostById(@PathVariable int id) {
		ModelAndView mv = new ModelAndView("postDetails");
		Post post = codeblogservice.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	
	@RequestMapping(value = "/newpost",  method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost",  method = RequestMethod.POST)
	public String savePost(@Valid Post post,BindingResult result,RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("error", "Verifique se os campos obrigatórios foram preenchidos");
			return "redirect:/newpost";
		}
		post.setData(LocalDate.now());
		codeblogservice.save(post);
		return "redirect:/posts";
	}
	
	@RequestMapping(value = "posts/delete/{id}")
	public String getDeletePost(@PathVariable int id) {
		codeblogservice.deleteById(id);
		return "redirect:/posts";
	}
	
	
}
