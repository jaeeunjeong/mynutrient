package com.mynutrient.demo.dto.domain.posts;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mynutrient.demo.domain.posts.Posts;
import com.mynutrient.demo.domain.posts.PostsRepository;

@WebAppConfiguration
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {
	
	@Autowired
	PostsRepository postsRepository;
	
	@After//
	public void cleanup() {
		postsRepository.deleteAll();
	}
	
	@Test
	public void 게시글저장_불러오기() {
		String title = "test post";
		String content = "test contents";
		
		postsRepository.save(Posts.builder()
				.title(title)
				.content(content)
				.author("jejeong000@gmail.com")
				.build());
		
		List<Posts> postsList  = postsRepository.findAll();
	
		Posts posts = postsList.get(0);
		assertThat(posts.getTitle()).isEqualTo(title);
		assertThat(posts.getContent()).isEqualTo(content);
	}
	
	@Test
	public void BaseTimeEntity_등록() {
		LocalDateTime now = LocalDateTime.of(2020,5,13,0,0,0);
		postsRepository.save(Posts.builder().title("title").content("contentt").author("jejeong000@gmail.com").build());
		
		
		List<Posts> postsList = postsRepository.findAll();
		   
		Posts posts = postsList.get(0);
		
		
		assertThat(posts.getCreatedDate()).isAfter(now);
		assertThat(posts.getModifiedDate()).isAfter(now);
	}
	
	
}
