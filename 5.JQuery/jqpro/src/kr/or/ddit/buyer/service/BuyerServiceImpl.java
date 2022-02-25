package kr.or.ddit.buyer.service;

import java.util.List;

import kr.or.ddit.buyer.dao.BuyerDaoImpl;
import kr.or.ddit.buyer.dao.IBuyerDao;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * dao클래스의 메서드 호출 : dao클래스 객체가 필요함
 * 
 * 싱글톤 처리 - controller에서 사용될 service클래스 객체를 생성하여 리턴함
 *
 */
public class BuyerServiceImpl implements IBuyerService {
	private IBuyerDao dao;
	private static IBuyerService service;
	
	//생성자
	private BuyerServiceImpl() {
		dao = BuyerDaoImpl.getDao();
	}
	
	//싱글톤 패턴
	public static IBuyerService getService() {
		if(service == null) service = new BuyerServiceImpl();
		
		return service;
	}
	
	@Override
	public List<BuyerVO> selectByName() {
		//List<BuyerVO> list = null;
		//list = dao.selectByName();
		//return list;
		return dao.selectByName();
	}

	@Override
	public BuyerVO selectDetail(String buyer_id) {
		return dao.selectDetail(buyer_id);
	}
}
