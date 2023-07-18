package kr.co.jhta.model;

import kr.co.jhta.dto.Pagination;
import kr.co.jhta.vo.Board;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class BoardList {

    // 페이지 내비게이션 정보
    private Pagination pagination;

    // 검색된 게시글 목록
    private List<Board> boards;
}
