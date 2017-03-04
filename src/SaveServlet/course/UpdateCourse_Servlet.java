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
import com.lyq.bean.service.C_Service;

@WebServlet("/UpdateCourse_Servlet")
public class UpdateCourse_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String No = request.getParameter("No");// 获取表单属性
		List<Course> list = new ArrayList<>();
		list = new C_Service().seek_C("编号", "精确查询", No, list);// 根据课程编号获得课程分配信息
		request.getSession().setAttribute("list", list); // 把list存在对象中
		request.getSession().setAttribute("c", list.toArray()[0]);
		request.getRequestDispatcher("/jsp/course/m/UpdateCourse.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String No = ((Course) request.getSession().getAttribute("c")).getNo();
		String time = request.getParameter("time");
		String place = request.getParameter("place");
		String credit = request.getParameter("credit");
		Boolean bool = new C_Service().update_C(No, time, place, credit);// 修改课程分配
		if (bool == true) {
			request.getSession().setAttribute("message", "修改课程分配成功！");
		} else {
			request.getSession().setAttribute("message", "修改课程分配失败！");
		}
		request.getSession().setAttribute("url", "RemoveCourse_Servlet?id=seekall");
		request.getRequestDispatcher("Message.jsp").forward(request, response);
	}
}
