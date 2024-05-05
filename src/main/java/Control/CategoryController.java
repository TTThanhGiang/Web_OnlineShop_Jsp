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
 * Servlet implementation class CategoryController
 */
@WebServlet("/category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DAO dao = new DAO();
		int page = 1;
		int pageSize = 6;
		int start = 1;
		String categoryID = "";
		int toView = 0;
		
		if(request.getParameter("page") != null)
			page = Integer.parseInt(request.getParameter("page"));
		if(request.getParameter("categoryID") != null)
			categoryID = request.getParameter("categoryID");
		if(request.getParameter("toview") != null)
			toView = Integer.parseInt(request.getParameter("toview"));
		if(page != 1)
			start = (page-1) * pageSize + 1;
		
		List<product> products = dao.getProducts(start, pageSize, categoryID);
		List<category> categories = dao.getCategories();
		int totalpage = dao.getTotalPage(pageSize, categoryID);
		request.setAttribute("page", page);
		request.setAttribute("product_list", products);
		request.setAttribute("category_list", categories);
		request.setAttribute("categoryID", categoryID);
		request.setAttribute("total_page", totalpage);
		request.setAttribute("toview", toView);
		request.getRequestDispatcher("category.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
