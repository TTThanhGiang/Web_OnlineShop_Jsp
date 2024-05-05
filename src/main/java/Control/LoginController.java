package Control;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import context.SQLSEVERDataAccess;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("name");
        String pass = request.getParameter("pass");
        SQLSEVERDataAccess con = new SQLSEVERDataAccess();
        ResultSet rs = con.getResultSet("select * from tbKHACHHANG");
        int kq = 0;
        try {
            while (rs.next()) {
                if(rs.getString("TAIKHOAN").equals(user) && rs.getString("MATKHAU").equals(pass)){
                    kq =1 ;
                }
            }
            if(kq == 1){
            	if(user.equals("admin")&& pass.equals("123456")) {
            		response.sendRedirect("homeAdmin.jsp");
                }
            	else {
            		HttpSession session = request.getSession();
                	session.setAttribute("user", user);
                	response.sendRedirect("Home");
            	}
            }
            else{
                    response.sendRedirect("login.jsp");
                }
                
        } catch (SQLException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
	}

}
