package kr.co.jhta.service;

import java.util.List;
import java.util.Map;

import kr.co.jhta.vo.User;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.BoardDao;
import kr.co.jhta.vo.Board;

@Service
@RequiredArgsConstructor
public class BoardService {

	private final BoardDao boardDao;
	
	// 새 게시글 등록하기
	public void createBoard(int userNo, String title, String content) {
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);

		User user = new User();
		user.setNo(userNo);
		board.setUser(user);

		 boardDao.insertBoard(board);
	}
	
	// 게시글 목록 조회하기(페이징처리 포함)
	public List<Board> getBoards(Map<String, Object> param) {
		return null;
	}
	
	
	// 게시글 정보 수정하기
	public void updateBoard(Board board) {
		
	}
}
