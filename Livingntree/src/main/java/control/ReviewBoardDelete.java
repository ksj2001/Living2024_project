package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LivingDAO;
import model.ReviewDTO;

@WebServlet("/ReviewBoardDelete.do")
public class ReviewBoardDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}
	
	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code = Integer.parseInt(request.getParameter("code"));
		
		LivingDAO ldao = new LivingDAO();
		ReviewDTO rdto = ldao.getOneUpdateReviewBoard(code);
		
		request.setAttribute("rdto", rdto);
		RequestDispatcher rd = request.getRequestDispatcher("BoardDeleteForm.jsp");
		rd.forward(request, response);
	}
}