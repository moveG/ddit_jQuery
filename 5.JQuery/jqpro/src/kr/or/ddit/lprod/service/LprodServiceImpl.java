package kr.or.ddit.lprod.service;

import java.util.List;

import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDaoImpl;
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * - dao 객체 얻어오기
 * 
 * - controller에서 사용될 service객체를 생성하고 리턴하는 메서드
 */
public class LprodServiceImpl implements ILprodService {
	private ILprodDao dao;
	private static ILprodService service;
	
	//생성자
	public LprodServiceImpl() {
		dao = LprodDaoImpl.getDao();
	}
	
	public static ILprodService getService() {
		if(service == null) service = new LprodServiceImpl();
		
		return service;
	}
	
	@Override
	public List<LprodVO> selectAllItem() {
		List<LprodVO> list = null;
		
		list = dao.selectAllItem();
		
		return list;
	}
}
