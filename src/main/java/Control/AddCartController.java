package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DAO;
import entity.cartItem;
import entity.product;

/**
 * Servlet implementation class AddCartController
 */
@WebServlet("/AddCartController")
public class AddCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		HttpSession session = request.getSession();
		String user = (String) session.getAttribute("user");
		if(user != null) {
			String productID = request.getParameter("ID");
			int quantity = Integer.parseInt(request.getParameter("QUANTITY"));

			if(quantity == 0) return;
			
			ArrayList<cartItem> cartList = new ArrayList<cartItem>();
			ArrayList<cartItem> cart_list = (ArrayList<cartItem>) session.getAttribute("cart-list");
			DAO dao = new DAO();
			
			if(cart_list == null) {
				product p = dao.getProductByTd(productID);
				cartItem cartItem = new cartItem(p, quantity);
				cartList.add(cartItem);
			} else {
				boolean isExist = false;
				cartList = cart_list;
				for (cartItem item : cartList) {
					if(item.getId().equals(productID)) {
						isExist = true;
						item.increaseQuantity(quantity);
						break;
					}
				}
				if(!isExist) {
					product p = dao.getProductByTd(productID);
					cartItem cartItem = new cartItem(p, quantity);
					cartList.add(cartItem);
				}
			}
			session.setAttribute("cart-list", cartList);
			response.sendRedirect("cart.jsp");
		}
		else
			response.sendRedirect("login.jsp");
	}
}
