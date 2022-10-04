package com.awsProject.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

// <Entity클래스, Pk타입>으로 상속하여 기본적인 CURD메소드가 자동생성
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
