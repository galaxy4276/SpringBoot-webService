package com.galaxy4276spring.domain.posts;

import com.galaxy4276spring.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity // 테이블과 링크될 클래스
public class Posts extends BaseTimeEntity {
  @Id // Pk 필드
  @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙
  private Long id;

  @Column(length = 500, nullable = false) // 테이블의 칼럼
  private String title;

  @Column(columnDefinition = "TEXT", nullable = false)
  private String content;

  private String author;

  @Builder
  public Posts(String title, String content, String author) {
    this.title = title;
    this.content = content;
    this.author = author;
  }

  public void update(String title, String content) {
    this.title = title;
    this.content = content;
  }
}
