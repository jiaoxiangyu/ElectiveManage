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

@WebServlet(name = "RemoveStudent_Servlet", urlPatterns = "/RemoveStudent_Servlet")
public class RemoveStudent_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String elect = request.getParameter("id");
		if (elect.equals("seekall")) {
			List<Student> list = new ArrayList<>();
			list = new S_Service().seekAll_S(list);// 查询所有学生信息
			request.setAttribute("list", list); // 把list储存在request对象中
			request.getRequestDispatcher("/jsp/student/m/RemoveStudent.jsp").forward(request, response);// 转到/AllBookInfo.jsp页面
		} else if (elect.equals("remove")) {
			String No = request.getParameter("No");
			Boolean bool = new S_Service().remove_S(No);// 删除学生信息
			if (bool == true) {
				request.getSession().setAttribute("message", "删除成功！");
			} else {
				request.getSession().setAttribute("message", "删除失败！");

			}
			request.getSession().setAttribute("url", "RemoveStudent_Servlet?id=seekall");
			response.sendRedirect("Message.jsp");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String select = request.getParameter("select"); // 获得表单属性
		String seek = request.getParameter("seek");
		String name = request.getParameter("name");
		if (name != null || name == "") {
			List<Student> list = new ArrayList<>();
			list = new S_Service().seek_S(select, seek, name, list);// 条件查询学生信息
			request.setAttribute("list", list); // 把list存在request对象中
			if (list.size() < 1 || list == null) {// 判断搜索结果是否为空
				request.getSession().setAttribute("message", "未找到你要查询的内容！");
				request.getSession().setAttribute("url", "RemoveStudent_Servlet?id=seekall");
				response.sendRedirect("Message.jsp");
			} else {
				request.getRequestDispatcher("/jsp/student/m/RemoveStudent.jsp").forward(request, response);
			}
		}

	}
}
