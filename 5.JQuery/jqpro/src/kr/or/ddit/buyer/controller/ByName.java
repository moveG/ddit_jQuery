package kr.or.ddit.buyer.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class ByName
 */
@WebServlet("/ByName.do")
public class ByName extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ByName() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//0. 요청 전송시 데이터를 받는다. - 현재는 없음
		
		//1. service객체 얻어오기
		IBuyerService service = BuyerServiceImpl.getService();
		
		//2. service메서드 호출하기 - 결과값 받기
		List<BuyerVO> list = service.selectByName();
		
		//3. 결과값을 request에 저장
		request.setAttribute("listAttr", list);
		
		//4. JSP로 forward - 출력, JSON데이터를 생성함
		RequestDispatcher disp = request.getRequestDispatcher("0930/buyerNames.jsp");
		
		disp.forward(request, response);
	}
}
