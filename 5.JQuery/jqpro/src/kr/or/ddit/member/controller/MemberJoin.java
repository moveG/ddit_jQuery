package kr.or.ddit.member.controller;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

/**
 * Servlet implementation class MemberJoin
 */
@WebServlet("/MemberJoin.do")
public class MemberJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberJoin() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		//0. 클라이언트 요청시 전송데이터를 받는다.
		//   (mem_id, mem_name, mem_pass,...)
		//   9개의 데이터를 받아서 setter를 이용해 vo에 저장함
		MemberVO vo = new MemberVO();
		/*
		vo.setMem_id(request.getParameter("mem_id"));
		vo.setMem_pass(request.getParameter("mem_pass"));
		vo.setMem_name(request.getParameter("mem_name"));
		vo.setMem_bir(request.getParameter("mem_bir"));
		vo.setMem_zip(request.getParameter("mem_zip"));
		vo.setMem_add1(request.getParameter("mem_add1"));
		vo.setMem_add2(request.getParameter("mem_add2"));
		vo.setMem_hp(request.getParameter("mem_hp"));
		vo.setMem_mail(request.getParameter("mem_mail"));
		*/
		//form의 name과 db의 컬럼명과 vo의 변수이름이 동일하면(대소문자 구분 필요) 일일이 넣을 필요없이 BeanUtils.populate();를 이용하여 한번에 처리할 수 있다.
		try {
			BeanUtils.populate(vo, request.getParameterMap());
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		//1. service객체 얻기
		IMemberService service = MemberServiceImpl.getService();
		
		//2. service메서드 호출 - 결과값 받기(입력한 id)
		String mem_id = service.insertMember(vo);
		
		//3. 결과값을 request에 저장
		request.setAttribute("mem_idAttr", mem_id);
		
		//4. JSP로 forward - 1005/
		request.getRequestDispatcher("1005/insert.jsp").forward(request, response);		
	}
}
