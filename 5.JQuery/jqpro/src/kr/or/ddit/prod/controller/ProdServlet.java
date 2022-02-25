package kr.or.ddit.prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.service.IProdService;
import kr.or.ddit.prod.service.ProdServiceImpl;
import kr.or.ddit.prod.vo.ProdVO;

/**
 * Servlet implementation class ProdServilet
 */
@WebServlet("/ProdServlet.do")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProdServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//lprod_gu를 파라미터로 해서 prod_id와 prod_name 가져오기
		
		//0. 요청 전송시 데이터를 받는다. - lprod_gu
		String lgu = request.getParameter("lprod_gu");
		//ajax의 data부분에서 파라미터를 받음
		
		//1. service객체 얻어오기
		IProdService service = ProdServiceImpl.getService();
		
		//2. service메서드 호출하기 - 결과값 받기
		List<ProdVO> list = service.selectProdByLgu(lgu);
		
		//3. 결과값을 request에 저장
		request.setAttribute("lguAttr", list);
		
		//4. JSP로 forward - 출력, JSON데이터를 생성함 - prodNames.jsp
		RequestDispatcher disp = request.getRequestDispatcher("1001/prodNames.jsp");
		
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//prod_id를 파라미터로 해서 상세보기 수행하기
		String pid = request.getParameter("prod_id");
		//0. 요청 전송시 데이터를 받는다. - prod_id
		//ajax의 data부분에서 파라미터를 받음
		
		//1. service객체 얻어오기
		IProdService service = ProdServiceImpl.getService();
		
		//2. service메서드 호출하기 - 결과값 받기
		ProdVO pv = service.selectByIdDetail(pid);
		
		//3. 결과값을 request에 저장
		request.setAttribute("pvAttr", pv);
		
		//4. JSP로 forward - 출력, JSON데이터를 생성함 - prodDetail.jsp
		RequestDispatcher disp = request.getRequestDispatcher("1001/prodDetail.jsp");
		
		disp.forward(request, response);	
	}
}
