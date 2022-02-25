package kr.or.ddit.board.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.board.vo.BoardVO;
import kr.or.ddit.board.vo.ReplyVO;

public interface IBoardService {
	//전체 리스트
	public List<BoardVO> selectAll();
	
	//페이지별 리스트
	public List<BoardVO> selectByPage(Map<String, Integer> map);
	
	//게시글 작성
	public int insertBoard(BoardVO vo);
	
	//게시글 수정
	public int updateBoard(BoardVO vo);
	
	//게시글 삭제
	public int deleteBoard(int num);
	
	//댓글 작성
	public int insertReply(ReplyVO vo);
	
	//댓글 리스트
	public List<ReplyVO> selectReply(int bonum);
	
	//댓글 수정
	public int updateReply(ReplyVO vo);
	
	//댓글 삭제
	public int deleteReply(int renum);
	
	//조회수 증가
	public int updateHit(int num);
	
	//전체 게시글 개수
	public int listCount();
}
