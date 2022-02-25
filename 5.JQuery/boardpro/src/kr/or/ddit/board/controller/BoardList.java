package kr.or.ddit.board.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.BoardVO;

/**
 * Servlet implementation class List
 */
@WebServlet("/BoardList.do")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//전체 리스트 가져오기
		IBoardService service = BoardServiceImpl.getInstance();
		
		List<BoardVO> list = service.selectAll();
		
		request.setAttribute("allList", list);
		
		request.getRequestDispatcher("board/list.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		//페이지별 리스트 가져오기
		//0. 클라이언트 요청시 전송되는 데이터 가져오기(현재 page)
		int spage = Integer.parseInt(request.getParameter("page"));
		
		IBoardService service = BoardServiceImpl.getInstance();
		
		int perList = 5;
		int perPage = 3;
		
		//전체 페이지수 구하기 - 전체 글 개수부터 알아야 함
		//count가 전체 글 개수(20개)
		int count = service.listCount();
		
		//하단 페이징 부분의 페이지 개수(한 페이지당 게시글 5개, 총페이지 개수 4개)
		int totalPage = (int)(Math.ceil(count / (double)perList));
		
		int startPage = ((spage - 1) / perPage * perPage) + 1;
		int endPage = startPage + perPage - 1;
		if(endPage > totalPage) endPage = totalPage;
		
		
		//spage의 값에 따라서 start와 end의 값이 변경됨
		int start = (spage - 1) * perList + 1;
		int end = start + perList - 1;		
		if(end > count) end = count;
		
		Map<String, Integer> map = new HashMap<String, Integer>();

		map.put("start", start);
		map.put("end", end);
		
		List<BoardVO> list = service.selectByPage(map);
		
		request.setAttribute("list", list);
		
		request.setAttribute("spage", startPage);
		request.setAttribute("epage", endPage);
		request.setAttribute("tpage", totalPage);
		request.setAttribute("curpage", spage);
		
		request.getRequestDispatcher("board/listPage.jsp").forward(request, response);
	}
}
