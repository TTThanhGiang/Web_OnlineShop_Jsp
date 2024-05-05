package Control;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import context.SQLSEVERDataAccess;
import dao.DAO;
import entity.product;

/**
 * Servlet implementation class EditProductController
 */
	@WebServlet("/EditProductController")
	public class EditProductController extends HttpServlet {
		private static final long serialVersionUID = 1L;
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			response.setContentType("text/html;charset=UTF-8");
			String action = request.getParameter("Action");
			String productId = request.getParameter("productId");
			DAO dao = new DAO();
			if(action.equals("0")) {
				product prd = dao.getProductByTd(productId);
				request.setAttribute("detail", prd);
				request.getRequestDispatcher("editproduct.jsp").forward(request, response);
			}
		}
		protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        response.setContentType("text/html;charset=UTF-8");
	        ServletContext context = request.getServletContext();
	        String realpath = context.getRealPath("/img/product"); 
	        MultipartRequest multi = new MultipartRequest(request, realpath);
            String MASANPHAM = multi.getParameter("product_id");
            String TENSANPHAM = multi.getParameter("product_name"); 
            String DONGIA = multi.getParameter("product_price");
            String SOLUONG = multi.getParameter("product_quantity");
            String MOTA = multi.getParameter("product_description");
            String fileName = multi.getFilesystemName("product_image");
            System.out.println("Name: " + TENSANPHAM + ", HinhAnh: " + fileName);
            
            Double dongia = Double.parseDouble(DONGIA);
            int soluong = Integer.parseInt(SOLUONG);
            
            SQLSEVERDataAccess con = new SQLSEVERDataAccess();
            product product = new product(MASANPHAM,TENSANPHAM,dongia,soluong,fileName,MOTA);
            String SQL = null;
            Object [] param = null;
            if(product.getImages()!= null) {
    			SQL= "update tbSANPHAM set TENSANPHAM =?, DONGIA=?,SOLUONG=?,HINHANH=?, MOTA=? where MASANPHAM= ?";
    			param = new Object[6];
    			param[0] = TENSANPHAM;
    			param[1] = dongia;
    			param[2] = soluong;
    			param[3] = fileName;
    			param[4] = MOTA;
    			param[5] = MASANPHAM;
    		}else {
    			SQL= "update tbSANPHAM set TENSANPHAM =?, DONGIA=?,SOLUONG=?, MOTA=? where MASANPHAM= ?";
    			param = new Object[5];
    			param[0] = TENSANPHAM;
    			param[1] = dongia;
    			param[2] = soluong;
    			param[3] = MOTA;
    			param[4] = MASANPHAM;
    		}
            con.ExecuteSQL(SQL, param);
            
            System.out.println("Product has been edit!");
            response.sendRedirect("ProductManagerController");          
	    }
		
	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        processRequest(request, response);
	    }
	
	}
