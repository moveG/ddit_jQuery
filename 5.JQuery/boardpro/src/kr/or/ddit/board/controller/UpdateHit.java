package kr.or.ddit.board.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;

/**
 * Servlet implementation class UpdateHit
 */
@WebServlet("/UpdateHit.do")
public class UpdateHit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateHit() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int cnt = service.updateHit(num);
		
		request.setAttribute("result", num);
		
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
	}
}
