package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LivingDAO;
import model.MemberDTO;
import model.ReviewDTO;

@WebServlet("/ReviewBoardWriteProc.do")
public class ReviewBoardWriteProc extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		LivingDAO ldao = new LivingDAO();
		ReviewDTO rdto = new ReviewDTO();
		
		HttpSession session = request.getSession();
		String loginId = (String)session.getAttribute("loginId");
		
		rdto.setR_pw(request.getParameter("password"));
		rdto.setR_title(request.getParameter("subject"));
		rdto.setR_content(request.getParameter("content"));
		rdto.setM_name(ldao.getOneName(loginId));
		rdto.setM_id(loginId);
		
		ldao.insertReviewBoard(rdto);
		RequestDispatcher rd = request.getRequestDispatcher("ReviewBoardList.do");
		rd.forward(request, response);
	}
}