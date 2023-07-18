package kr.co.jhta.web.controller;

import kr.co.jhta.model.BoardList;
import kr.co.jhta.vo.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.jhta.service.BoardService;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

	private final BoardService boardService;

	// 게시글 목록화면 요청과 매핑되는 요청핸들러 메소드
	@GetMapping("/list")
	public String list(Model model) {

		Map<String, Object> param = new HashMap<>();
		BoardList result = boardService.getBoards(param);

		model.addAttribute("result", result);

		return "/board/list";
	}

	// 새 게시글 등록화면 요청과 매핑되는 요청핸들러 메소드
	@GetMapping("/register")
	public String form() {

		return "/board/form";
	}

	// 새 게시글 등록요청과 매핑되는 요청핸들러 메소드
	@PostMapping("/register")
	public String register(@AuthenticationPrincipal User user, String title, String content) {
		boardService.createBoard(user.getNo(), title, content);

		return "redirect:/board/list";
	}

	// 최신 게시글 목록(가장  최근에 등록된 게시글 10개)요청과 매핑되는 요청핸들러 메소드

	// 게시글 상세정보 화면 요청과 매핑되는 요청 핸들러 메소드

	// 게시글 삭제 요청과 매핑되는 요청 핸들러 메소드

	// 게시글 수정화면 요청과 매핑되는 요청 핸들러 메소드

	// 게시글 수정요청과 매핑되는 요청 핸들러 메소드
}
