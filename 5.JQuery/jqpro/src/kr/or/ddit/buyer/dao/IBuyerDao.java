package kr.or.ddit.buyer.dao;

import java.util.List;

import kr.or.ddit.buyer.vo.BuyerVO;

public interface IBuyerDao {
	//설계도 - 메서드를 구현하지 않고, 선언만 함
	public List<BuyerVO> selectByName();
	public BuyerVO selectDetail(String buyer_id);
}
