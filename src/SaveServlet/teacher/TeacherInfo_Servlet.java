package SaveServlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Teacher;
import com.lyq.bean.service.T_Service;

@WebServlet("/TeacherInfo_Servlet")
public class TeacherInfo_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String id = request.getParameter("id");
		String No = (String) request.getSession().getAttribute("UNAME");// 获得教师工号
		List<Teacher> list = new ArrayList<>();
		list = new T_Service().seek_T("工号", "精确查询", No, list);// 获得教师信息
		Teacher t = (Teacher) list.toArray()[0];
		request.getSession().setAttribute("t", t); // 把list储存在request对象中
		if (id.equals("info")) {
			request.getRequestDispatcher("/jsp/teacher/t/TeacherInfo.jsp").forward(request, response);// 转到/AllBookInfo.jsp页面
		} else if (id.equals("update")) {
			request.getRequestDispatcher("/jsp/teacher/t/UpdateTeacherInfo.jsp").forward(request, response);// 转到/AllBookInfo.jsp页面
		}
	}
}
