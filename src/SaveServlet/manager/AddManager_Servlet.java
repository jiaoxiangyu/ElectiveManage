package SaveServlet.manager;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.service.M_Service;

@WebServlet(name = "AddManager_Servlet", urlPatterns = "/AddManager_Servlet")
public class AddManager_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// 获取表单中属性值		
		String username = request.getParameter("username");// 获取表单属性
		String pwd = request.getParameter("password");
		Boolean bool = new M_Service().add_M(username, pwd);// 添加管理员
		if (bool == true) {
			request.getSession().setAttribute("message", "添加管理员成功！");
		} else {
			request.getSession().setAttribute("message", "该用户名已存在，添加管理员失败！");
		}
		request.getSession().setAttribute("url", "jsp/manager/AddManager.jsp");
		request.getRequestDispatcher("Message.jsp").forward(request, response);
	}
}
