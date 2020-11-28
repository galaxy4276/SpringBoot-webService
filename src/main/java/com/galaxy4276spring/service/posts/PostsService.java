package com.galaxy4276spring.service.posts;

import com.galaxy4276spring.domain.posts.Posts;
import com.galaxy4276spring.domain.posts.PostsRepository;
import com.galaxy4276spring.web.dto.PostsListResponseDto;
import com.galaxy4276spring.web.dto.PostsResponseDto;
import com.galaxy4276spring.web.dto.PostsSaveRequestDto;
import com.galaxy4276spring.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.stream.Collectors;
import java.util.List;


@RequiredArgsConstructor
@Service
public class PostsService {
  private final PostsRepository postsRepository;

  @Transactional
  public Long save(PostsSaveRequestDto requestDto) {
    return postsRepository.save(requestDto.toEntity()).getId();
  }

  @Transactional
  public Long update(Long id, PostsUpdateRequestDto requestDto) {
    Posts posts = postsRepository.findById(id).orElseThrow(() -> new
      IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

    posts.update(requestDto.getTitle(), requestDto.getContent());

    return id;
  }

  @Transactional
  public PostsResponseDto findById (Long id) {
    Posts entity = postsRepository.findById(id).orElseThrow(() -> new
      IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

    return new PostsResponseDto(entity);
  }

  @Transactional
  public List<PostsListResponseDto> findAllDesc() {
    return postsRepository.findAllDesc().stream()
        .map(PostsListResponseDto::new)
        .collect(Collectors.toList());
  }
}
