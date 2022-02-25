package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {
	private SqlMapClient client;
	private static IBoardDao dao;
	
	public BoardDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IBoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}

	@Override
	public List<BoardVO> boardList() {
		List<BoardVO> list = null;
		
		try {
			list = client.queryForList("board.boardList");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public BoardVO boardRead(int board_no) {
		BoardVO vo = null;
		
		try {
			vo = (BoardVO) client.queryForObject("board.boardRead", board_no);
			
			System.out.println(vo.getBoard_date());
			System.out.println(vo.getBoard_content());
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
}
