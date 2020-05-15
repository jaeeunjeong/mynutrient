package com.mynutrient.demo.web;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mynutrient.demo.dto.PostsResponseDto;
import com.mynutrient.demo.dto.PostsSaveRequestDto;
import com.mynutrient.demo.dto.PostsUpdateRequestDto;
import com.mynutrient.demo.service.PostsService;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
public class PostsApiController {

	private final PostsService postsService;
	
	@PostMapping("/api/v1/posts")
	public Long save(@RequestBody PostsSaveRequestDto requestDto) {
		return postsService.save(requestDto);
	}
	@PutMapping("/api/v1/posts/{id}")
	public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto) {
		return postsService.update(id, requestDto);
	}
	@GetMapping("/api/v1/posts/{id}")
	public PostsResponseDto findById(@PathVariable Long id) {
		return postsService.findById(id);
	}
	
	@DeleteMapping("/api/v1/posts/{id}")
	public long delete(@PathVariable Long id) {
		
		postsService.delete(id);
		
		return id;
	}
}