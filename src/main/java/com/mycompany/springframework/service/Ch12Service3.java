package com.mycompany.springframework.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

// 관리객체는 이름으로 관리가 된다.
// 기본적으로 클래스의 첫자를 소문자로한 이름으로 관리 (ch12Service3)
@Service
@Slf4j
public class Ch12Service3 {
	public Ch12Service3() {
		log.info("실행");
	}
}