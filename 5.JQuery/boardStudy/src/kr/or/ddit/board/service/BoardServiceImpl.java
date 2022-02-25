package kr.or.ddit.board.service;

import java.util.List;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao dao;
	private static IBoardService service;
	
	public BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	
	public static IBoardService getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<BoardVO> boardList() {
		return dao.boardList();
	}

	@Override
	public BoardVO boardRead(int board_no) {
		return dao.boardRead(board_no);
	}
}
