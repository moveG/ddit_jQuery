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
 * Servlet implementation class DeleteBoard
 */
@WebServlet("/DeleteBoard.do")
public class DeleteBoard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBoard() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		int num = Integer.parseInt(request.getParameter("num"));
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int cnt = service.deleteBoard(num);
		
		int perList = 5;
		int count = service.listCount();
		int totalPage = (int)(Math.ceil(count / (double)perList));
		
		request.setAttribute("result", cnt);
		request.setAttribute("tpage", totalPage);
		
		request.getRequestDispatcher("board/delete.jsp").forward(request, response);
	}
}
