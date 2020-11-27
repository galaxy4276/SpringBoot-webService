package com.galaxy4276spring.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

  @Test
  public void lombokTest() {
    // given
    String name = "test";
    int amount = 1000;

    // When
    HelloResponseDto dto = new HelloResponseDto(name, amount);

    // Then
    assertThat(dto.getName()).isEqualTo(name);
    assertThat(dto.getAmount()).isEqualTo(amount);
  }
}

/*
  assertThat
    -> 테스트 검정 라이브러리의 검증 메서드
    검증 대상을 인자로 받는다.

  isEqualTo
    -> assertj의 동등 비교 메서드
 */