package com.mycompany.springframework.controller;

import java.io.*;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.springframework.dto.Ch13Board;
import com.mycompany.springframework.dto.Ch13Pager;
import com.mycompany.springframework.service.Ch13Service;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequestMapping("/ch13")
public class Ch13Controller {
	// 필드 주입
	@Autowired
	private Ch13Service service;

	@GetMapping("/writeBoardForm")
	public String writeBoardForm() {
		return "ch13/writeBoardForm";
	}

	@PostMapping("/writeBoard")
	public String writeBoard(Ch13Board board) {
		log.info("btitle: " + board.getBtitle() + ", bcontent: " + board.getBcontent());
		
		// 요청 데이터의 유효성 검사
		// 파일 원래 이름과 type 로그 출력 --------------------------
		log.info("original filename: " + board.getBattach().getOriginalFilename());
		log.info("filetype: " + board.getBattach().getContentType());

		// (첨부 파일이 있는지 여부 조사)첨부파일이 넘어오지 않을 경우 상황도 생각해줘야 함
		// 첨부파일이 존재하는 경우
		if (board.getBattach() != null && !board.getBattach().isEmpty()) {
			// DTO 추가 설정
			board.setBattachoname(board.getBattach().getOriginalFilename());
			board.setBattachtype(board.getBattach().getContentType());
			try {
				// 비즈니스 로직 측에서 발생하는 예외는 없기 때문에, try-catch로 예외처리 함
				board.setBattachdata(board.getBattach().getBytes());
			} catch (Exception e) {
			}
		}

		// 로그인된 사용자 아이디 설정
		board.setMid("user");

		// 비즈니스 로직 처리를 서비스로 위임
		service.writeBoard(board);

		return "redirect:/ch13/boardList";
	}

	@GetMapping("/boardList")
	public String boardList(String pageNo, Model model, HttpSession session) {
		// 게시글 상세보기 에서 목록을 누르면 첫번째 페이지로 이동하니까,
		// session 에서 페이지 넘버 가져오기
		// pageNo를 받지 못했을 경우 저장되어 있는지 확인
		if (pageNo == null) {
			pageNo = (String) session.getAttribute("pageNo");
			if (pageNo == null) {
				// 세션에 저장되어 있지 않을 경우 "1"로 강제 세팅
				pageNo = "1";
			}
		}
		// 세션에 pageNo 저장
		session.setAttribute("pageNo", pageNo);
		// 문자열을 정수로 변환
		int intPageNo = Integer.parseInt(pageNo);

		// 페이징 대상이 되는 전체 행의 수 구하기
		// 만약에, 검색어를 이용해서 전체 행의 수를 구한다면 searchRows 라는 서비스 메소드를 만들어서 진행하기
		// Pager 객체 생성
		int rows = service.getTotalRows();

		// Service 에서 게시물 목록 요청
		Ch13Pager pager = new Ch13Pager(10, 10, rows, intPageNo);
		List<Ch13Board> boardList = service.getBoardList(pager);

		// jsp 에서 사용할 수 있도록 설정
		model.addAttribute("pager", pager);
		model.addAttribute("boardList", boardList);

		return "ch13/boardList";
	}

	@GetMapping("/detailBoard")
	public String detailBoard(int bno, Model model) {
		Ch13Board board = service.getBoard(bno);

		model.addAttribute("board", board);

		return "ch13/detailBoard";
	}

	@GetMapping("/attachDownload")
	public void attachDownload(int bno, HttpServletResponse response) throws Exception {
		// 다운로드할 데이터를 준비
		Ch13Board board = service.getBoard(bno);
		byte[] data = service.getAttachData(bno);

		// 응답 헤더 구성
		response.setContentType(board.getBattachtype());
		// 한글 파일의 이름 -> 인코딩 변경
		String fileName = new String(board.getBattachoname().getBytes("UTF-8"), "ISO-8859-1");
		response.setHeader("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
		// 응답 본문에 파일 데이터 출력
		OutputStream os = response.getOutputStream();
		os.write(data);
		os.write(data);
		os.flush();
		os.close();
	}

	@GetMapping("/updateBoardForm")
	public String updateBoardForm(int bno, Model model) {
		Ch13Board board = service.getBoard(bno);

		model.addAttribute("board", board);

		return "ch13/updateBoardForm";
	}

	@PostMapping("/updateBoard")
	public String updateBoard(Ch13Board board) {
		// (첨부 파일이 있는지 여부 조사)첨부파일이 넘어오지 않을 경우 상황도 생각해줘야 함
		// 첨부파일이 존재하는 경우
		if (board.getBattach() != null && !board.getBattach().isEmpty()) {
			// DTO 추가 설정
			board.setBattachoname(board.getBattach().getOriginalFilename());
			board.setBattachtype(board.getBattach().getContentType());
			try {
				// 비즈니스 로직 측에서 발생하는 예외는 없기 때문에, try-catch로 예외처리 함
				board.setBattachdata(board.getBattach().getBytes());
			} catch (Exception e) {
			}
		}

		// 비즈니스 로직 처리를 서비스로 위임
		service.updateBoard(board);

		return "redirect:/ch13/detailBoard?bno=" + board.getBno();
	}
	
	@GetMapping("/deleteBoard")
	public String deleteBoard(int bno) {
		service.removeBoard(bno);
		return "redirect:/ch13/boardList";
	}

}
