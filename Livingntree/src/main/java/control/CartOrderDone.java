package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CartDTO;
import model.DelivDTO;
import model.LivingDAO;
import model.OrdersDTO;
import model.ProductDTO;

@WebServlet("/CartOrderDone.do")
public class CartOrderDone extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		LivingDAO ldao = new LivingDAO();
		OrdersDTO odto = new OrdersDTO();
		DelivDTO ddto = new DelivDTO();
		CartDTO cdto = new CartDTO();
		/* ProductDTO pdto = new ProductDTO(); */
		ArrayList<OrdersDTO> arr = new ArrayList<>();
		
		String[] codearr = request.getParameterValues("code");
		String[] imgarr = request.getParameterValues("img");
		String[] namearr = request.getParameterValues("name");
		String[] cntarr = request.getParameterValues("cnt");
		String[] pricearr = request.getParameterValues("price");
		String[] delivfeearr = request.getParameterValues("delivfee");
		String id = request.getParameter("id");
		int c_code = Integer.parseInt(request.getParameter("c_code"));
		
		int orderCode = ldao.codeaddSelect();
		
		// 구매 테이블에 insert
		for(int i=0;i<codearr.length;i++) {
			odto.setO_date(odto.getO_date());
			odto.setO_code(orderCode);
			odto.setP_code(Integer.parseInt(codearr[i]));
			odto.setO_qty(Integer.parseInt(cntarr[i]));
			odto.setO_total(Integer.parseInt(pricearr[i])*Integer.parseInt(cntarr[i]));
			odto.setM_id(id);
			arr.add(odto);
			ldao.insertOrders(odto);
		}
		
		// 구매한 물품은 장바구니에서 삭제
		for(int i=0;i<codearr.length;i++) {
			ldao.deleteOrderCart(Integer.parseInt(codearr[i]), id);
		}
		
		// 배송지 테이블에 insert
		ddto.setO_date(odto.getO_date());
		ddto.setO_code(odto.getO_code());
		ddto.setD_delivname(request.getParameter("name"));
		ddto.setD_postcode(Integer.parseInt(request.getParameter("postcode")));
		ddto.setD_defaultaddr(request.getParameter("defaultaddr"));
		ddto.setD_detailaddr(request.getParameter("detailaddr"));
		ddto.setD_phone(request.getParameter("phone1")+"-"+request.getParameter("phone2")+"-"+request.getParameter("phone3"));
		ddto.setD_email(request.getParameter("email"));
		ddto.setM_id(id);
		ldao.insertDeliv(ddto);
		
		
		request.setAttribute("date", odto.getO_date());
		request.setAttribute("code", odto.getO_code());
		
		RequestDispatcher rd = request.getRequestDispatcher("Main.jsp?section=CartOrderResult.jsp");
		rd.forward(request, response);
	}
}
