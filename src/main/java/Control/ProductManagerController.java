package Control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.category;
import entity.product;

/**
 * Servlet implementation class ProductManagerController
 */
@WebServlet("/ProductManagerController")
public class ProductManagerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		String categoryId = request.getParameter("category");
		String productId = request.getParameter("productId");
		String action = request.getParameter("Action");
		DAO dao = new DAO();
		List<product> list = new ArrayList<product>();		
		List<category> listDanhMuc = dao.ListDanhMuc();
		
		if(action == null) {
			list = dao.getAllProduct();
	        if (categoryId!= null) {
	        	if(categoryId.equals("all"))
	        		list = dao.getAllProduct();
	        	else
	        		list = dao.ListSanPhamDM(categoryId);
	        }
		}
		else if (action.equals("0")) {
			int k = dao.DeleteProduct(productId);
			if(k == 0) {
				System.out.println("Product "+productId+" has been removed");
				list = dao.getAllProduct();
		        if (categoryId!= null) {
		        	if(categoryId.equals("all"))
		        		list = dao.getAllProduct();
		        	else
		        		list = dao.ListSanPhamDM(categoryId);
		        }
			}
			
		}

		
        
        
		request.setAttribute("ListDM", listDanhMuc);
		request.setAttribute("ListSP", list);
		request.getRequestDispatcher("productmanager.jsp").forward(request, response);
		
	}


}
