package Control;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import context.SQLSEVERDataAccess;

/**
 * Servlet implementation class AddProductCotroller
 */
@WebServlet("/AddProductCotroller")
public class AddProductCotroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try {
            ServletContext context = request.getServletContext();
            String realpath = context.getRealPath("/img/product"); 
            MultipartRequest multi= new MultipartRequest(request, realpath);
            SQLSEVERDataAccess con = new SQLSEVERDataAccess();
            //Lấy mã sản phẩm mới nhất + 1
            ResultSet rs = con.getResultSet("select max(cast(substring(masanpham,6,len(masanpham)) as int) + 1) from tbsanpham");
            String temp = "";
            while (rs.next()) {
                temp = rs.getString(1);
            }
            String MASANPHAM = "SP000" + temp;
            String TENSANPHAM = multi.getParameter("product_name"); 
            String DONGIA = multi.getParameter("product_price");
            String SOLUONG = multi.getParameter("product_quantity");
            String MADANHMUC = multi.getParameter("selMadanhmuc");
            String MOTA = multi.getParameter("product_description");
            String fileName = multi.getFilesystemName("product_image");
            
			String SQL = " insert into tbSANPHAM(MASANPHAM,TENSANPHAM,DONGIA,SOLUONG,HINHANH,MOTA,MADANHMUC)"
                        + "values(?,?,?,?,?,?,?)"; 
            Object [] param = {MASANPHAM,TENSANPHAM,DONGIA,SOLUONG,fileName,MOTA,MADANHMUC};
            con.ExecuteSQL(SQL, param);
            response.sendRedirect("ProductManagerController");
        } catch(Exception ex){
            ex.printStackTrace();
        } 
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
