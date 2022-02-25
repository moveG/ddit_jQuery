package kr.or.ddit.board.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.board.service.BoardServiceImpl;
import kr.or.ddit.board.service.IBoardService;
import kr.or.ddit.board.vo.ReplyVO;

/**
 * Servlet implementation class ReplySave
 */
@WebServlet("/ReplySave.do")
public class ReplySave extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplySave() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//0. 클라이언트 요청시 reply객체를 이용하여 값 가져오기
		//BeanUtils로 대체
		//request.getParameter("bonum");
		//request.getParameter("name");
		//request.getParameter("cont");
		
		ReplyVO vo = new ReplyVO();
		
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//1. service객체 얻기
		IBoardService service = BoardServiceImpl.getInstance();
		
		//2. service메서드 호출 - 결과값 받기
		int renum = service.insertReply(vo);
		
		//3. 결과값을 request에 저장
		request.setAttribute("result", renum);
		
		//4. JSP로 forward - result.jsp
		request.getRequestDispatcher("board/result.jsp").forward(request, response);
	}
}
