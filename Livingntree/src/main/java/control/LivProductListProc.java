package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.LivingDAO;
import model.ProductDTO;

@WebServlet("/LivProductListProc.do")
public class LivProductListProc extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		reqPro(request, response);
	}

	protected void reqPro(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LivingDAO ldao = new LivingDAO();
		
		String category = "";
		if(category != null) {
			category = request.getParameter("p_category");
		}
		
		String order = request.getParameter("order");
		if(order == null) {
			order = "1";
		}
		
		// 페이징 시작
		
		int pageSize = 12;
		
		String pageNum = request.getParameter("pageNum");
		if(pageNum==null) {
			pageNum = "1";
		}
		
		int count = 0;
		int number = 0;
		
		int currentPage = Integer.parseInt(pageNum);
		
		count = ldao.getAllProductCount(Integer.parseInt(category));
		
		int startRow = (currentPage - 1) * pageSize + 1;
		int endRow = currentPage * pageSize;
		
		ArrayList<ProductDTO> plist = new ArrayList<>();
		
		if(Integer.parseInt(order) == 1) {
			plist = ldao.getAllProduct(Integer.parseInt(category), startRow, pageSize);
		}else if(Integer.parseInt(order) == 2) {
			plist = ldao.getAllProductAscPrice(Integer.parseInt(category), startRow, pageSize);
		}else {
			plist = ldao.getAllProductDescPrice(Integer.parseInt(category), startRow, pageSize);
		}
		
		number = count - (currentPage - 1) * pageSize;
		
		int pageCount = 0;
		int pageBlock = 1;
		int startPage = 1;
		int endPage = 0;
		
		if(count>0) {
			pageCount = count / pageSize + (count % pageSize == 0 ? 0 : 1);
			
			if(currentPage % pageBlock != 0) {
				startPage = (currentPage / pageBlock) * pageBlock + 1;
			}else {
				startPage = ((currentPage / pageBlock)-1) * pageBlock + 1;
			}
			
			endPage = startPage + pageBlock - 1;
			
			if(endPage > pageCount) {
				endPage = pageCount;
			}
		}
		
		// 페이징 종료
		request.setAttribute("count", count);
		request.setAttribute("pageNum", pageNum);
		request.setAttribute("currentPage", currentPage);
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageBlock", pageBlock);
		request.setAttribute("startPage", startPage);
		request.setAttribute("endPage", endPage);

		request.setAttribute("category", category);
		request.setAttribute("order", order);
		request.setAttribute("plist", plist);
		RequestDispatcher rd = request.getRequestDispatcher("Main.jsp?section=ProductList.jsp");
		rd.forward(request, response);
	}
}
