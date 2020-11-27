package com.galaxy4276spring.web;

import com.galaxy4276spring.web.HelloController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

  @Autowired
  private MockMvc mvc;

  @Test
  public void hello() throws Exception {
    String hello = "hello";

    mvc.perform(get("/hello"))
      .andExpect(status().isOk())
      .andExpect(content().string(hello));
  }

  @Test
  public void helloDto() throws Exception {
    String name = "name";
    int amount = 1000;

    mvc.perform(
      get("/hello/dto")
        .param("name", name)
        .param("amount", String.valueOf(amount))
    )
      .andExpect(status().isOk())
      .andExpect(jsonPath("$.name", is(name)))
      .andExpect(jsonPath("$.amount", is(amount)));
  }
}

/*
  jsonPath
    -> $를 기준으로 필드명을 명시하고 검증한다.
 */