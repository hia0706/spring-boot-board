package kr.co.jhta.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.service.UserService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

	private final UserService userService;

	// 사용자 등록화면 요청과 매핑되는 요청핸들러 메소드
	@GetMapping("/register")
	public String form() {

		return "/user/registerform";
	}

	// 사용자 등록 요청과 매핑되는 요청핸들러 메소드
	@PostMapping("/register")
	public String register(String email, String password) {
		userService.createUser(email, password);

		return "redirect:/";
	}

	// 로그인 화면 요청과 매핑되는  요청핸들러 메소드

	// 내정보보기 화면 요청과 매핑되는 요청핸들러 메소드

	// 내정보수정화면 요청과 매핑되는 요청핸들러 메소드

	// 내정보 수정 요청과 매팅되는 요청핸들러 메소드
}
