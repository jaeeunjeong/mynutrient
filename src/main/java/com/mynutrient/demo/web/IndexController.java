package com.mynutrient.demo.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mynutrient.demo.dto.PostsResponseDto;
import com.mynutrient.demo.service.PostsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostsService postService;
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("posts",postService.findAllDesc());
		return "index";
	}

	@GetMapping("/posts/save")
	public String postsSave() {
		return "posts-Save";//얘네는 대소문자를 안 가리나...;;
	}

	@GetMapping("/posts/update/{id}")
	public String postsUpdate(@PathVariable Long id, Model model) {
		
		PostsResponseDto dto = postService.findById(id);
		model.addAttribute("post",dto);
		
		return "posts-update";
	}
}
