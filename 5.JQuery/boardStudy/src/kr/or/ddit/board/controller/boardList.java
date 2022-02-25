package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

@WebServlet("/boardList.do")
public class boardList extends HttpServlet {
	
	public boardList() {
		super();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		IBoardService service = BoardServiceImpl.getInstance();
		
		List<BoardVO> list = service.boardList();
		
		req.setAttribute("listAttr", list);
		
		req.getRequestDispatcher("board/boardList.jsp").forward(req, resp);
	}
}
