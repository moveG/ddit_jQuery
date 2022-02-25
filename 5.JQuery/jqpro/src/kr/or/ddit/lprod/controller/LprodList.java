package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.lprod.vo.LprodVO;

/**
 * Servlet implementation class LprodList
 */
@WebServlet("/LprodList.do")
//아래의 LprodList는 중요하지 않고, 어노테이션의 /LprodList.do가 중요함
public class LprodList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LprodList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//0. 클라이언트 요청(전송)시 데이터 전달
		
		//1. service객체 얻어오기
		ILprodService service = LprodServiceImpl.getService();
		
		//2. service메서드 호출하기 - 결과값 받음
		List<LprodVO> list = service.selectAllItem();
		
		//3. 결과값을 request에 저장
		request.setAttribute("serviceAttr", list);
		
		//4. JSP에 forward
		RequestDispatcher disp = request.getRequestDispatcher("1001/lprodList.jsp");
		
		disp.forward(request, response);
	}
}
