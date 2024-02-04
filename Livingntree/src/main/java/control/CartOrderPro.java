package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CartDTO;
import model.LivingDAO;

public class CartOrderPro extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		LivingDAO ldao = new LivingDAO();
		CartDTO cdto = new CartDTO();
		ArrayList<CartDTO> aList = new ArrayList<>(); 
		
		String loginId = request.getParameter("loginId");
		String chk = request.getParameter("chk");
		String chkArr[] = chk.split(" ");
		
		for(int i=0;i<chkArr.length;i++) {
			int check = Integer.parseInt(chkArr[i]);
			cdto = ldao.getCartSelect(check);
			aList.add(cdto);
		}
		
		// 배송지 정보는 보류
		// -----------------
		
		request.setAttribute("aList", aList);
		RequestDispatcher rd = request.getRequestDispatcher("CartOrder.jsp");
		rd.forward(request, response);
	}	
}
