package com.mycompany.springframework.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch17")
public class Ch17Controller {
	
	@GetMapping("/loginForm")
	public String loginForm() {
		return "ch17/loginForm";
	}
	
	@Secured("ROLE_ADMIN")
	@GetMapping("/admin/page")
	public String adminPage() {
		return "ch17/admin/page";
	}
	
	@Secured("ROLE_MANAGER")
	@GetMapping("/manager/page")
	public String managerPage() {
		return "ch17/manager/page";
	}
	
	@Secured("ROLE_USER")
	@GetMapping("/user/page")
	public String userPage() {
		return "ch17/user/page";
	}
	
	@RequestMapping("/error403")
	public String errorPage() {
		return "ch17/error403";
	}
}
