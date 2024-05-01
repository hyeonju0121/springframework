package com.mycompany.springframework.dto;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Ch13Board {
	private int bno;
	private String btitle;
	private String bcontent;
	private Date bdate;
	private String mid;
	private int bhitcount;
	private String battachoname; // 파일 원래 이름
	private String battachsname; // 저장된 파일 이름
	private String battachtype; // 파일 종류
	private byte[] battachdata;
	
	private MultipartFile battach;

}
