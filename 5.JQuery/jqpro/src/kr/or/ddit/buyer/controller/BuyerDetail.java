package kr.or.ddit.buyer.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.buyer.service.BuyerServiceImpl;
import kr.or.ddit.buyer.service.IBuyerService;
import kr.or.ddit.buyer.vo.BuyerVO;

/**
 * Servlet implementation class BuyerDetail
 */
@WebServlet("/BuyerDetail.do")
public class BuyerDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuyerDetail() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//0. 클라이언트 요청시 id값을 가져오기
		String bid = request.getParameter("id");
		
		//1. service객체 얻어오기
		IBuyerService service = BuyerServiceImpl.getService();
		
		//2. service메서드 호출하기 - 결과값 받기
		BuyerVO vo = service.selectDetail(bid);
		
		//3. 결과값을 request에 저장
		request.setAttribute("aa", vo);
		
		//4. JSP로 forward - 출력, JSON데이터를 생성함
		RequestDispatcher disp = request.getRequestDispatcher("0930/buyerDetail.jsp");
		
		disp.forward(request, response);
	}

}
