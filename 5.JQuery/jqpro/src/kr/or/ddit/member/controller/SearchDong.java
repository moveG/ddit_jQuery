package kr.or.ddit.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.ZipVO;

/**
 * Servlet implementation class SearchDong
 */
@WebServlet("/SearchDong.do")
public class SearchDong extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchDong() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//0. 클라이언트 요청시 전송데이터를 받는다.(dong)
		String dong = request.getParameter("dong");
		
		//1. service객체 얻기
		IMemberService service = MemberServiceImpl.getService();
		
		//2. service메서드 호출 - 결과값 받기
		List<ZipVO> zipList = service.selectZipCode(dong);
		
		//3. 결과값을 request에 저장
		request.setAttribute("zipAttr", zipList);
		
		//4. JSP로 forward - 1005/zipcode.jsp
		request.getRequestDispatcher("1005/zipcode.jsp").forward(request, response);
	}
}
