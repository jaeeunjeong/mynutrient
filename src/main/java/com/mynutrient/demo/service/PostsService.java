package com.mynutrient.demo.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mynutrient.demo.domain.posts.Posts;
import com.mynutrient.demo.domain.posts.PostsRepository;
import com.mynutrient.demo.dto.PostsResponseDto;
import com.mynutrient.demo.dto.PostsSaveRequestDto;
import com.mynutrient.demo.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class PostsService {

	private final PostsRepository postsRepository;
	
	@Transactional
	public Long save(PostsSaveRequestDto requestDto) {
		//return PostsRepository.save(requestDto.toEntity().getId());
		return postsRepository.save(requestDto.toEntity()).getId();
	}
	
	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("�ش� �Խñ��� �����ϴ� id="+id));
		
		posts.update(requestDto.getTitle(), requestDto.getContent());
		return id;
	}
	
	public PostsResponseDto findById(Long id) {
		Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("�ش� �Խñ��� �����ϴ� id="+id));
		return new PostsResponseDto(entity);    
	}
}
      