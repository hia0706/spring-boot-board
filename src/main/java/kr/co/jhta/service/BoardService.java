package kr.co.jhta.service;

import java.util.List;
import java.util.Map;

import kr.co.jhta.dto.Pagination;
import kr.co.jhta.model.BoardList;
import kr.co.jhta.vo.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.jhta.dao.BoardDao;
import kr.co.jhta.vo.Board;

@Service
@RequiredArgsConstructor
@Slf4j
public class BoardService {

	private final BoardDao boardDao;
	
	/**
	 * 새 게시글 등록하기
	 * @param userNo 로그인한 사용자
	 * @param title 게시글 제목
	 * @param content 게시글 내용
	 */
	public void createBoard(int userNo, String title, String content) {
		Board board = new Board();
		board.setTitle(title);
		board.setContent(content);

		User user = new User();
		user.setNo(userNo);
		board.setUser(user);

		 boardDao.insertBoard(board);
	}

	/**
	 * 게시글 목록 조회하기(페이징처리 포함)
	 * @param param 요청파라미터가 정보를 포함하는 Map 객체
	 * @return 페이징, 게시글목록 정보가 포함된 BoardList 객체
	 */
	public BoardList getBoards(Map<String, Object> param) {
		int totalRows = boardDao.getTotalRows(param);
		log.info("totalRows -> {}", totalRows );
		int page = (int) param.get("page");
		log.info("page -> {}", page);
		int rows = (int) param.get("rows");
		log.info("row -> {}", rows);
		Pagination pagination = new Pagination(rows, page, totalRows);

		int begin = pagination.getBegin();
		int end = pagination.getEnd();
		param.put("begin", begin);
		param.put("end", end);

		BoardList result = new BoardList();
		List<Board> boards = boardDao.getBoards(param);

		result.setPagination(pagination);
		result.setBoards(boards);
		log.info("result -> {}", result);
		return result;
	}
	
	
	// 게시글 정보 수정하기
	public void updateBoard(Board board) {
		
	}
}
