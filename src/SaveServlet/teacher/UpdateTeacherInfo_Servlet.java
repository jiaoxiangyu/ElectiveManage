package SaveServlet.teacher;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Teacher;
import com.lyq.bean.service.T_Service;

@WebServlet("/UpdateTeacherInfo_Servlet")
public class UpdateTeacherInfo_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String No = ((Teacher) request.getSession().getAttribute("t")).getNo();
		String name = request.getParameter("username");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String collage = request.getParameter("collage");
		String pwd = request.getParameter("password");
		Boolean bool = new T_Service().updateteacherInfo(No, name, sex, age, collage, pwd);// 修改教师信息
		if (bool != null) {
			request.getSession().setAttribute("message", "修改成功！");
		} else {
			request.getSession().setAttribute("message", "修改失败！");
		}
		request.getSession().setAttribute("url", "TeacherInfo_Servlet?id=update");
		response.sendRedirect("Message.jsp");
	}
}
