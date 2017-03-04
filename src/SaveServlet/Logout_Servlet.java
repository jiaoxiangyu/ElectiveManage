package SaveServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Logout_Servlet")
public class Logout_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getSession().invalidate();//注销session		
		request.getRequestDispatcher("Logout.jsp").forward(request, response);//所有页面刷新到上级窗口
	}	
}
