package Control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import context.SQLSEVERDataAccess;

/**
 * Servlet implementation class SignInContronller
 */
@WebServlet("/SignInContronller")
public class SignInContronller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInContronller() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String hten = request.getParameter("Name").trim();
            String user = request.getParameter("Username");
            String email = request.getParameter("Email");
            String Password = request.getParameter("Password");
            SQLSEVERDataAccess con = new SQLSEVERDataAccess();

            String insert = "insert into tbKHACHHANG(HOTEN,EMAIL,TAIKHOAN,MATKHAU) "
                    + " values(N'" + hten + "' ,'" + email + "','" + user + "','" + Password + "')";
            int kq = con.ExecuteSQL(insert);

            if (kq != 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", user);
                response.sendRedirect("index.jsp");
            } else {
                response.sendRedirect("login.jsp");
            }

        }
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

}
