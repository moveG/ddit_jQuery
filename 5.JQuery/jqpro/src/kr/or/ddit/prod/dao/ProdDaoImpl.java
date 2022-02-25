package kr.or.ddit.prod.dao;

import java.sql.SQLException;
import java.util.List;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.ibatis.config.SqlMapClientFactory;
import kr.or.ddit.prod.vo.ProdVO;

public class ProdDaoImpl implements IProdDao {
	private SqlMapClient client;
	private static IProdDao dao;
	
	//생성자
	public ProdDaoImpl() {
		client = SqlMapClientFactory.getInstance();
	}
	
	public static IProdDao getDao() {
		if(dao == null) dao = new ProdDaoImpl();
		
		return dao;
	}
	
	@Override
	public List<ProdVO> selectProdByLgu(String gu) {
		List<ProdVO> list = null;
		
		try {
			list = client.queryForList("prod.selectProdByLgu", gu);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public ProdVO selectByIdDetail(String id) {
		ProdVO po = null;
		
		try {
			po = (ProdVO) client.queryForObject("prod.selectByIdDetail", id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return po;
	}

}
