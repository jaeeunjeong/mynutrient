package com.mynutrient.demo.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mynutrient.demo.domain.posts.Posts;
import com.mynutrient.demo.domain.posts.PostsRepository;
import com.mynutrient.demo.dto.PostsListResponseDto;
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
		// return PostsRepository.save(requestDto.toEntity().getId());
		return postsRepository.save(requestDto.toEntity()).getId();
	}

	@Transactional
	public Long update(Long id, PostsUpdateRequestDto requestDto) {
		Posts posts = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다." + id));

		posts.update(requestDto.getTitle(), requestDto.getContent());
		return id;
	}

	public PostsResponseDto findById(Long id) {
		Posts entity = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다." + id));
		return new PostsResponseDto(entity);
	}
	
	@Transactional//(readOnly = true)
	public List<PostsListResponseDto> findAllDesc() {
		return postsRepository.findAllDesc().stream().map(posts -> new PostsListResponseDto(posts))
				.collect(Collectors.toList());
	}
	
	
	@Transactional
	public void delete(Long id) {
		Posts posts = postsRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다." + id));

		postsRepository.delete(posts);
	}
}
