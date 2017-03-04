package SaveServlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.service.T_Service;

@WebServlet(name = "AddTeacher_Servlet", urlPatterns = "/AddTeacher_Servlet")
public class AddTeacher_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String No = request.getParameter("No");// 获取表单属性
		String name = request.getParameter("username");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String collage = request.getParameter("collage");
		String pwd = request.getParameter("password");
		Boolean bool = new T_Service().add_T(No, name, sex, age, collage, pwd);// 添加教师
		if (bool == true) {
			request.setAttribute("message", "教师用户添加成功！");
		} else {
			request.setAttribute("message", "该用户名已存在，教师用户添加失败！");
		}
		request.getSession().setAttribute("url", "jsp/teacher/m/AddTeacher.jsp");
		request.getRequestDispatcher("Message.jsp").forward(request, response);
	}
}
