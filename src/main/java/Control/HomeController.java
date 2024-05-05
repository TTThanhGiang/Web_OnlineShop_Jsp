package Control;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DAO;
import entity.product;

/**
 * Servlet implementation class HomeController
 */
@WebServlet( "/Home") 
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		DAO dao = new DAO();
		List<product> list = dao.getAllProduct();	
		for (product data : list) {
            System.out.println(data.getName());
        }
		request.setAttribute("ListSP", list);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
