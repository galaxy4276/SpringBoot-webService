/*
    앞으로 만들 프로젝트의 메인 클래스
    @SpringBootApplication -> 스프링 부트의 자동 설정, Bean 읽기와 생성 등..
    항상 프로젝트 최상단에 위치해야한다.
*/

package com.galaxy4276spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args); // 내장 WAS(web application server) 실행
        // Tomcat을 설치할 필요가 없게 된다.
    }
}
