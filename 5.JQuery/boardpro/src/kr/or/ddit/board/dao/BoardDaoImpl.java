package kr.or.ddit.board.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;
import kr.or.ddit.ibatis.config.SqlMapClientFactory;

public class BoardDaoImpl implements IBoardDao {
	private SqlMapClient smc;
	
	//싱글톤 패턴 적용
	private static IBoardDao dao;
	private BoardDaoImpl() {
		smc = SqlMapClientFactory.getInstance();
	}
	public static IBoardDao getInstance() {
		if(dao == null) {
			dao = new BoardDaoImpl();
		}
		return dao;
	}
	
	//전체 리스트
	@Override
	public List<BoardVO> selectAll() throws SQLException {
		return smc.queryForList("board.selectAll");
	}
	
	//페이지별 리스트
	@Override
	public List<BoardVO> selectByPage(Map<String, Integer> map) throws SQLException {
		return smc.queryForList("board.selectByPage", map);
	}
	
	//게시글 작성
	@Override
	public int insertBoard(BoardVO vo) throws SQLException {
		return (Integer) smc.insert("board.insertBoard", vo);
	}
	
	//게시글 수정
	@Override
	public int updateBoard(BoardVO vo) throws SQLException {
		return smc.update("board.updateBoard", vo);
	}
	
	//게시글 삭제
	@Override
	public int deleteBoard(int num) throws SQLException {
		return smc.delete("board.deleteBoard", num);
	}
	
	//댓글 작성
	@Override
	public int insertReply(ReplyVO vo) throws SQLException {
		return (Integer) smc.insert("reply.insertReply", vo);
	}
	
	//댓글 리스트
	@Override
	public List<ReplyVO> selectReply(int bonum) throws SQLException {
		return smc.queryForList("reply.selectReply", bonum);
	}
	
	//댓글 수정
	@Override
	public int updateReply(ReplyVO vo) throws SQLException {
		return smc.update("reply.updateReply", vo);
	}
	
	//댓글 삭제
	@Override
	public int deleteReply(int renum) throws SQLException {
		return smc.delete("reply.deleteReply", renum);
	}
	
	//조회수 증가
	@Override
	public int updateHit(int num) throws SQLException {
		return smc.update("board.updateHit", num);
	}
	
	//전체 게시글 개수
	@Override
	public int listCount() throws SQLException {
		return (Integer) smc.queryForObject("board.listCount");
	}
}
