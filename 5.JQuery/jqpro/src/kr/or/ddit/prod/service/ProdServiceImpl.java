package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdServiceImpl implements IProdService {
	private IProdDao dao;
	private static IProdService service;
	
	//생성자
	public ProdServiceImpl() {
		dao = ProdDaoImpl.getDao();
	}
	
	public static IProdService getService() {
		if(service == null) service = new ProdServiceImpl();
		
		return service;
	}
	
	@Override
	public List<ProdVO> selectProdByLgu(String gu) {
		List<ProdVO> list = null;
		
		list = dao.selectProdByLgu(gu);
		
		return list;
	}

	@Override
	public ProdVO selectByIdDetail(String id) {
		ProdVO po = null;
		
		po = dao.selectByIdDetail(id);
		
		return po;
	}
}
