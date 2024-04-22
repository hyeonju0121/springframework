package com.mycompany.springframework.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch12Service10 {
	
	// 필드 주입
	@Value("${prop1}") private int field1;
	@Value("${prop2}") private double field2;
	@Value("${prop3}") private boolean field3;
	private String field4;
	
	// @Value("${prop3}") (x) -> @Value 는 생성자 주입은 안됨
	/*public Ch12Service10(boolean field3) {
		this.field3 = field3;
	}*/

	@Value("${prop4}")
	public void setField4(String field4) {
		this.field4 = field4;
		
		log.info("field1: " + field1);
		log.info("field2: " + field2);
		log.info("field3: " + field3);
		log.info("field4: " + field4);
	}
}
