package com.galaxy4276spring.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        return "hello"; // /hello GET -> return STRING of Hello
    }
}

/*
    @RestController
        -> 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어준다.
    @GetMapping
        -> HTTP Method GET 요청을 받을 수 있는 API를 만들어준다.
*/