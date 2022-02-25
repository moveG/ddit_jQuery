package kr.or.ddit.board.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import kr.or.ddit.board.dao.BoardDaoImpl;
import kr.or.ddit.board.dao.IBoardDao;
import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public class BoardServiceImpl implements IBoardService {
	private IBoardDao dao;
	
	//싱글톤 패턴 적용
	private static IBoardService service;
	private BoardServiceImpl() {
		dao = BoardDaoImpl.getInstance();
	}
	public static IBoardService getInstance() {
		if(service == null) {
			service = new BoardServiceImpl();
		}
		return service;
	}
	
	//전체 리스트
	@Override
	public List<BoardVO> selectAll() {
		List<BoardVO> list = null;
		
		try {
			list = dao.selectAll();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//페이지별 리스트
	@Override
	public List<BoardVO> selectByPage(Map<String, Integer> map) {
		List<BoardVO> list = null;
		
		try {
			list = dao.selectByPage(map);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//게시글 작성
	@Override
	public int insertBoard(BoardVO vo) {
		int num = 0;
		
		try {
			num = dao.insertBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return num;
	}
	
	//게시글 수정
	@Override
	public int updateBoard(BoardVO vo) {
		int cnt = 0;
		
		try {
			cnt = dao.updateBoard(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	//게시글 삭제
	@Override
	public int deleteBoard(int num) {
		int cnt = 0;
		
		try {
			cnt = dao.deleteBoard(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	//댓글 작성
	@Override
	public int insertReply(ReplyVO vo) {
		int renum = 0;
		
		try {
			renum = dao.insertReply(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return renum;
	}
	
	//댓글 리스트
	@Override
	public List<ReplyVO> selectReply(int bonum) {
		List<ReplyVO> list = null;
		
		try {
			list = dao.selectReply(bonum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//댓글 수정
	@Override
	public int updateReply(ReplyVO vo) {
		int cnt = 0;
		
		try {
			cnt = dao.updateReply(vo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	//댓글 삭제
	@Override
	public int deleteReply(int renum) {
		int cnt = 0;
		
		try {
			cnt = dao.deleteReply(renum);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	//조회수 증가
	@Override
	public int updateHit(int num) {
		int cnt = 0;
		
		try {
			cnt = dao.updateHit(num);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	//전체 게시글 개수
	@Override
	public int listCount() {
		int count = 0;
		
		try {
			count = dao.listCount();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}
}
