package Control;

import java.io.IOException;
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
 * Servlet implementation class DetailController
 */
@WebServlet("/DetailController")
public class DetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String id = request.getParameter("pid");
		DAO dao = new DAO();
		product p = dao.getProductByTd(id);
		category c = dao.getCatoryByTd(id);
		List<product> list = dao.getAllProduct();	
		request.setAttribute("ListSP", list);
		request.setAttribute("detail", p);
		request.setAttribute("danhmuc", c);
		request.getRequestDispatcher("detais.jsp").forward(request, response);
	}
}
