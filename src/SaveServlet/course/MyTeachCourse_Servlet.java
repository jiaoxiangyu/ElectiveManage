package SaveServlet.course;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Course;
import com.lyq.bean.Student;
import com.lyq.bean.service.TC_Service;

@WebServlet("/MyTeachCourse_Servlet")
public class MyTeachCourse_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String id = request.getParameter("id");
		if (id.equals("seekmine")) {
			String tNo = (String) request.getSession().getAttribute("UNAME");// 获得该教师工号
			List<Course> list = new ArrayList<>();
			list = new TC_Service().getTeachC(tNo); // 查询该教师的所有课程
			request.setAttribute("list", list); // 把list储存在request对象中
			if (list.size() > 0) {
				request.getRequestDispatcher("/jsp/teacher/t/MyTeachCourse.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("message", "没有你的课程！");
				request.getSession().setAttribute("url", "");
				response.sendRedirect("Message.jsp");
			}
		} else if (id.equals("student")) {
			String cNo = request.getParameter("No");// 获得课程编号
			List<Student> list = new ArrayList<>();
			list = new TC_Service().seekElectS(cNo);// 查询选修该课程的学生
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/teacher/t/MyStudents.jsp").forward(request, response);
		}
	}
}
