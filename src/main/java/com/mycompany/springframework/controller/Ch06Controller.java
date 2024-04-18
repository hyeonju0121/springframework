package com.mycompany.springframework.controller;

import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dto.Ch06Cart;
import com.mycompany.springframework.dto.Ch06Member;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch06")
public class Ch06Controller {
	
	@GetMapping("/forward")
	public String forward(Model model, HttpServletRequest request) {
		// 데이터 생성
		Ch06Member member = new Ch06Member();
		member.setMid("hyeonju0121");
		member.setMname("유현주");
		member.setMemail("hyeonju__@naver.com");
		
		// request 범위에 객체 저장 ------------------
		// (forward할 때까지 계속 사용할 수 있는 범위)
		// 응답이 전송되면 request 범위는 사라짐
		// --------------------------------------
		model.addAttribute("chNum", "ch06");
		
		model.addAttribute("member1", member);
		request.setAttribute("member2", member);
		
		return "ch06/forward";
	}
	
	@GetMapping("/redirect")
	public String redirect(HttpSession session) {
		log.info("실행");
		
		// 데이터 생성
		List<String> items = new ArrayList<>();
		items.add("상품1");
		items.add("상품2");
		items.add("상품3");
		
		Ch06Cart cart = new Ch06Cart();
		cart.setItems(items);
		
		// session 범위에 저장
		// 동일한 client(브라우저)가 사용할 수 있는 범위
		session.setAttribute("cart", cart);
		
		return "redirect:/ch06/sessionData";
	}
	
	@GetMapping("/sessionData")
	public String sessionData(Model model, HttpSession session) {
		log.info("실행");
				
		// session 범위에 저장된 객체 가져오기
		Ch06Cart cart = (Ch06Cart) session.getAttribute("cart");
		if(cart != null) {
			for (String item : cart.getItems()) {
				log.info("item: " + item);
			}
		}
		
		model.addAttribute("chNum", "ch06");
		
		return "ch06/sessionData";
	}
}
