package SaveServlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Student;
import com.lyq.bean.service.S_Service;

@WebServlet("/StudentInfo_Servlet")
public class StudentInfo_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String id = request.getParameter("id");
		String No = (String) request.getSession().getAttribute("UNAME");// 获得该学生的学号
		List<Student> list = new ArrayList<>();
		list = new S_Service().seek_S("学号", "精确查询", No, list);// 根据学号查询学生信息
		Student s = (Student) list.toArray()[0];
		request.getSession().setAttribute("s", s); // 把list储存在request对象中
		if (id.equals("info")) {
			request.getRequestDispatcher("/jsp/student/s/StudentInfo.jsp").forward(request, response);// 转到/AllBookInfo.jsp页面
		} else if (id.equals("update")) {
			request.getRequestDispatcher("/jsp/student/s/UpdateStudentInfo.jsp").forward(request, response);// 转到/AllBookInfo.jsp页面
		}

	}
}
