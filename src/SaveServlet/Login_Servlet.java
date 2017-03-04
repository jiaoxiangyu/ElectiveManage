package SaveServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.User;
import com.lyq.bean.service.Login_service;

@WebServlet(name = "Login_Servlet", urlPatterns = "/Login_Servlet") // 注释配置文件
public class Login_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 获取表单中属性值,		
		String Usersort = request.getParameter("UserSort"); // 获得用户登录类型、用户名、密码
		String Username = request.getParameter("username");
		String Pwd = request.getParameter("pwd");
		User user = new User();
		user = new Login_service().getLoginSql(Usersort, Username, Pwd);
		if (user != null) {
			request.getSession().setAttribute("UNAME", Username);// 用户名
			request.getSession().setAttribute("SORT", Usersort);// 身份
			if (Usersort.equals("管理员")) {// 用户类型为管理员时转换到M_Home.jsp页面
				request.getRequestDispatcher("/jsp/manager/M_Home.jsp").forward(request, response);
			} else if (Usersort.equals("学生")) {// 用户类型为学生时转换到R_Home.jsp页面
				request.getRequestDispatcher("/jsp/student/s/S_Home.jsp").forward(request, response);
			} else if (Usersort.equals("教师")) {// 用户类型为教师时转换到T_Home.jsp页面
				request.getRequestDispatcher("/jsp/teacher/t/T_Home.jsp").forward(request, response);
			}
		} else {// 发出错误提示
			request.getSession().setAttribute("message", "用户名或密码错误，请重写输入！");
			request.getSession().setAttribute("url", "Login.jsp");
			response.sendRedirect("Message.jsp");
		}
	}
}
