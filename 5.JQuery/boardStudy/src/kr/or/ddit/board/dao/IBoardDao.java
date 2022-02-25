package kr.or.ddit.board.dao;

import java.util.List;

import kr.or.ddit.board.vo.BoardVO;

public interface IBoardDao {
	public List<BoardVO> boardList();
	public BoardVO boardRead(int board_no);
}
