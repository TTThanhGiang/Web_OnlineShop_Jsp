package Control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.cartItem;

/**
 * Servlet implementation class CartController
 */
@WebServlet("/CartController")
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		// action = work
				// 0 = remove
				// 1 = increase
				// 2 = decrease
				// SqlAction(request, response);
				
				int action = Integer.parseInt(request.getParameter("ACTION"));
				String productID = request.getParameter("ID");
				HttpSession session = request.getSession();
				ArrayList<cartItem> cartList = (ArrayList<cartItem>) session.getAttribute("cart-list");
				
				if(action == 0) {
					for (cartItem product : cartList) {
						if(product.getId().equals(productID)) {
							cartList.remove(cartList.indexOf(product));
							break;
						}
					}
				}
				if(action == 1) {
					for (cartItem product : cartList) {
						if(product.getId().equals(productID)) {
							product.increaseQuantity(1);
							break;
						}
					}
				}
				if(action == 2) {
					for (cartItem product : cartList) {
						if(product.getId().equals(productID)) {
							if(product.getQuantity() > 1)
								product.decreaseQuantity();
							break;
						}
					}
				}
				response.sendRedirect("cart.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
