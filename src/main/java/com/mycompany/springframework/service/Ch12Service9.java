package com.mycompany.springframework.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.springframework.dao.Ch12DaoInterface;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class Ch12Service9 {
	// 필드주입 -------------------------------------------
	// @Autowired 사용했을 때, 이름을 명시하는 방법
	// @Autowired @Qualifier("name")
	@Autowired @Qualifier("ch12Dao6") private Ch12DaoInterface field1;
	
	// @Resource 사용했을 때, 이름을 명시하는 방법
    // @Resource(name="name")
	@Resource(name="ch12Dao7") private Ch12DaoInterface field2;

	// 생성자 주입 -------------------------------------------
	@Autowired
	public Ch12Service9(@Qualifier("ch12Dao6") Ch12DaoInterface field1) {
		
	}

	// 세터 주입 --------------------------------------------
	@Resource(name="ch12Dao7")
	public void setField2(Ch12DaoInterface field2) {
		this.field2 = field2;
	}
}
