package com.mynutrient.demo.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.mynutrient.demo.config.auth.LoginUser;
import com.mynutrient.demo.config.auth.dto.SessionUser.SessionUser;
import com.mynutrient.demo.dto.PostsResponseDto;
import com.mynutrient.demo.service.PostsService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

	private final PostsService postService;
	//private final HttpSession httpSession;
	
	@GetMapping("/")
	public String index(Model model, @LoginUser SessionUser user) {
		model.addAttribute("posts",postService.findAllDesc());
		//SessionUser user = (SessionUser) httpSession.getAttribute("user");
		if(user != null) {
			model.addAttribute("userName", user.getName());
		}
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
