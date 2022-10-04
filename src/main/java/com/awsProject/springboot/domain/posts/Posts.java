package com.awsProject.springboot.domain.posts;

import com.mysql.cj.protocol.ColumnDefinition;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //클래스 내 모든 필드의 Getter메소드 자동 생성
@NoArgsConstructor  //기본생성자 자동추가
@Entity //테이블과 링크될 클래스임을 나타냄
public class Posts {

    @Id //해당테이블의 pk필드를 나타냄
    @GeneratedValue(strategy = GenerationType.IDENTITY) // pk생성 규칙 스프링 2.0이상부터는 IDENTITY옵션이 있어야 auto incremnent가 됨
    private Long id;

    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder //해당 클래스의 빌더 패턴 클래스 생성
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }
}
