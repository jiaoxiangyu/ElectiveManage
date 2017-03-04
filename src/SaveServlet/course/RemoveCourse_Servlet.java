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

@WebServlet(name = "RemoveCourse_Servlet", urlPatterns = "/RemoveCourse_Servlet")
public class RemoveCourse_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String id = request.getParameter("id");
		if (id.equals("seekall")) {// 查询所有课程分配
			List<Course> list = new ArrayList<>();
			list = new C_Service().seekAll_C(list);
			request.setAttribute("list", list); // 把list储存在request对象中
			request.getRequestDispatcher("/jsp/course/m/RemoveCourse.jsp").forward(request, response);// 转到/AllBookInfo.jsp页面
		} else if (id.equals("remove")) {
			String No = request.getParameter("No"); // 获得课程编号
			Boolean bool = new C_Service().remove_C(No);// 删除课程分配
			if (bool == true) {
				request.getSession().setAttribute("message", "删除成功！");
			} else {
				request.getSession().setAttribute("message", "删除失败！");

			}
			request.getSession().setAttribute("url", "RemoveCourse_Servlet?id=seekall");
			response.sendRedirect("Message.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {	
		String select = request.getParameter("select"); // 获得表单属性
		String seek = request.getParameter("seek");
		String name = request.getParameter("name");
		if (name != null || name == "") {
			List<Course> list = new ArrayList<>();
			list = new C_Service().seek_C(select, seek, name, list);
			request.setAttribute("list", list); // 把list存在request对象中
			if (list.size() < 1 || list == null) {// 判断搜索结果是否为空
				request.getSession().setAttribute("message", "未找到你要查询的内容！");
				request.getSession().setAttribute("url", "RemoveCourse_Servlet?id=seekall");
				response.sendRedirect("Message.jsp");
			} else {
				request.getRequestDispatcher("/jsp/course/m/RemoveCourse.jsp").forward(request, response);
			}
		}
	}
}
