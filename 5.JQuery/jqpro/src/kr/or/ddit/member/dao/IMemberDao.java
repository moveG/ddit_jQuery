package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.member.vo.ZipVO;

public interface IMemberDao {
	//id중복 검사
	public String selectById(String inputId) throws SQLException;
	
	//우편번호 찾기
	public List<ZipVO> selectZipCode(String dong) throws SQLException;
	
	//회원가입
	public String insertMember(MemberVO vo) throws SQLException;
}
