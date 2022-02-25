package kr.or.ddit.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/boardRead.do")
public class boardRead extends HttpServlet{
	
	public boardRead() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		int board_no = Integer.parseInt(req.getParameter("board_no"));
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		BoardVO bv = service.boardRead(board_no);
		
		req.setAttribute("readAttr", bv);
		
		req.getRequestDispatcher("board/boardRead.jsp").forward(req, resp);
	}
}
