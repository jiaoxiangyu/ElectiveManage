package SaveServlet.student;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Student;
import com.lyq.bean.service.S_Service;

@WebServlet("/UpdateStudentInfo_Servlet")
public class UpdateStudentInfo_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String No = ((Student) request.getSession().getAttribute("s")).getNo();// 获得学号
		String name = request.getParameter("username");
		String sex = request.getParameter("sex");
		String age = request.getParameter("age");
		String collage = request.getParameter("collage");
		String department = request.getParameter("department");
		String pwd = request.getParameter("password");
		// 修改学生信息
		Boolean bool = new S_Service().updateStuInfo(No, name, sex, age, collage, department, pwd);
		if (bool != null) {
			request.getSession().setAttribute("message", "修改成功！");
		} else {
			request.getSession().setAttribute("message", "修改失败！");
		}
		request.getSession().setAttribute("url", "StudentInfo_Servlet?id=update");
		response.sendRedirect("Message.jsp");
	}

}
