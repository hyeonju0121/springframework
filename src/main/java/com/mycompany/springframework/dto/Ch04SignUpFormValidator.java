package com.mycompany.springframework.dto;

import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Ch04SignUpFormValidator implements Validator{

	/**
	 supports method 
	 유효성 검사기가 지원하는 폼을 지정
	 지원하는 폼이면 true 리턴, 아니면 false 리턴
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		log.info("실행");
		return Ch04SignUpForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Ch04SignUpForm signUpForm = (Ch04SignUpForm) target;
		
		// 아이디 검사
		String mid = signUpForm.getMid();
		if(mid == null || mid.equals("")) {
			errors.rejectValue("mid", null, "아이디는 반드시 입력해야 합니다.");
		} else if(mid.length() < 6 || mid.length() > 12) {
			errors.rejectValue("mid", null, "아이디는 6자 이상, 12자 이하로 입력해야 합니다.");
		}
		
		// 패스워드 검사 
		String mpassword = signUpForm.getMpassword();
		String pattern = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,15}";
		if(mpassword == null || mpassword.equals("")) {
			errors.rejectValue("mpassword", null, "패스워드는 반드시 입력해야 합니다.");
		} else if(mpassword.length() < 8 || mpassword.length() > 15) {
			errors.rejectValue("mpassword", null, "패스워드는 8자 이상, 15자 이하로 입력해야 합니다.");
		} else if(!Pattern.matches(pattern, mpassword)) {
			errors.rejectValue("mpassword", null, "패스워드는 알파벳 대소문자 및 숫자를 포함해야 합니다.");
		}
		
		
		// 이름 검사
		String mname = signUpForm.getMname();
		if(mname == null || mname.equals("")) {
			errors.rejectValue("mname", null, "이름은 반드시 입력해야 합니다.");
		} 
		
		
		// 이메일 검사
		String memail = signUpForm.getMemail();
		String emailPattern = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		if(memail == null || memail.equals("")) {
			errors.rejectValue("memail", null, "이메일은 반드시 입력해야 합니다.");
		} else if(!Pattern.matches(emailPattern, memail)) {
			errors.rejectValue("memail", null, "이메일 형식이 올바르지 않습니다.");
		}
		
		// 전화번호 검사
		String mnumber = signUpForm.getMnumber();
		String phonePattern = "(010|011)-\\d{3,4}-\\d{4}";
		if(mnumber == null || mnumber.equals("")) {
			errors.rejectValue("mnumber", null, "전화번호는 반드시 입력해야 합니다.");
		} else if(!Pattern.matches(phonePattern, mnumber)) {
			errors.rejectValue("mnumber", null, "전화번호 형식이 올바르지 않습니다.");
		}
	}

}
