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

@WebServlet(name = "RemoveTeacher_Servlet", urlPatterns = "/RemoveTeacher_Servlet")
public class RemoveTeacher_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String id = request.getParameter("id");
		if (id.equals("seekall")) {
			List<Teacher> list = new ArrayList<>();
			list = new T_Service().seekAll_T(list);
			request.setAttribute("list", list); // 把list储存在request对象中
			request.getRequestDispatcher("/jsp/teacher/m/RemoveTeacher.jsp").forward(request, response);// 转到/AllBookInfo.jsp页面
		} else if (id.equals("remove")) {
			String No = request.getParameter("No"); // 获得教师学号
			Boolean bool = new T_Service().remove_T(No);// 删除该教师
			if (bool == true) {
				request.getSession().setAttribute("message", "删除成功！");
			} else {
				request.getSession().setAttribute("message", "删除失败！");

			}
			request.getSession().setAttribute("url", "RemoveTeacher_Servlet?id=seekall");
			response.sendRedirect("Message.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String select = request.getParameter("select"); // 获得表单属性
		String seek = request.getParameter("seek");
		String name = request.getParameter("name");
		if (name != null || name == "") {
			List<Teacher> list = new ArrayList<>();
			list = new T_Service().seek_T(select, seek, name, list);
			request.setAttribute("list", list); // 把list存在request对象中
			if (list.size() < 1 || list == null) {// 判断搜索结果是否为空
				request.getSession().setAttribute("message", "未找到你要查询的内容！");
				request.getSession().setAttribute("url", "RemoveTeacher_Servlet?id=seekall");
				response.sendRedirect("Message.jsp");
			} else {
				request.getRequestDispatcher("/jsp/teacher/m/RemoveTeacher.jsp").forward(request, response);
			}
		}
	}
}
