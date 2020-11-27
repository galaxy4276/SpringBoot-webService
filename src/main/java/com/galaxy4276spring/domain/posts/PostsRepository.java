package com.galaxy4276spring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

/*
  JpaRepository<Entity Class, PK Type> 상속 시 기본적 CRUD 메서드 자동 생성
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {

}

