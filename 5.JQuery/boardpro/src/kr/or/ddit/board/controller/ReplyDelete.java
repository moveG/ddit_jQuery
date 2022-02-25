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
 * Servlet implementation class ReplyDelete
 */
@WebServlet("/ReplyDelete.do")
public class ReplyDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyDelete() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//0.
		int renum = Integer.parseInt(request.getParameter("renum"));
		
		//댓글 삭제
		IBoardService service = BoardServiceImpl.getInstance();
		
		int cnt = service.deleteReply(renum);
		
		request.setAttribute("result", cnt);
		
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
	}
}
