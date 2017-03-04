package SaveServlet.teacher;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Elective;
import com.lyq.bean.Student;
import com.lyq.bean.service.TC_Service;

@WebServlet("/Grade_Servlet")
public class Grade_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String id = request.getParameter("id");
		if (id.equals("grade")) {
			String cNo = request.getParameter("cNo");// 获得课程编号和学号
			String sNo = request.getParameter("sNo");
			Elective e = new Elective();
			e = new TC_Service().getElective(cNo, sNo);// 根据学号和课程编号获得选课成绩
			request.getSession().setAttribute("e", e);
			request.getRequestDispatcher("/jsp/teacher/t/Grade.jsp").forward(request, response);
		} else if (id.equals("seekall")) {// 查询该教师的所有学生
			String tNo = (String) request.getSession().getAttribute("UNAME");
			List<Student> list = new ArrayList<>();
			list = new TC_Service().SeekAllMyStudent(tNo);
			request.setAttribute("list", list);
			request.getRequestDispatcher("/jsp/teacher/t/MyStudents.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String id = request.getParameter("id");
		if (id.equals("grade")) {
			Elective e = new Elective();
			e = (Elective) request.getSession().getAttribute("e");
			String cNo = e.getcNo();
			String sNo = e.getsNo();
			String grade = request.getParameter("grade");
			Boolean bool = new TC_Service().grade(cNo, sNo, grade);// 评分
			if (bool == true) {
				request.getSession().setAttribute("message", "评分成功！");
			} else {
				request.getSession().setAttribute("message", "评分失败！");
			}
			request.getRequestDispatcher("Message_2.jsp").forward(request, response);
		} else if (id.equals("seek")) {
			String select = request.getParameter("select"); // 获得表单属性
			String seek = request.getParameter("seek");
			String name = request.getParameter("name");
			String tNo = (String) request.getSession().getAttribute("UNAME");
			List<Student> list = new ArrayList<>();
			list = new TC_Service().SeekMyStudent(tNo, select, seek, name);// 条件查询该教师的学生
			if (list.size() > 0) {
				request.setAttribute("list", list); // 把list存在request对象中
				request.getRequestDispatcher("jsp/teacher/t/MyStudents.jsp").forward(request, response);
			} else {
				request.getSession().setAttribute("message", "未搜索到结果！");
				request.getSession().setAttribute("url", "Grade_Servlet?id=seekall");
				response.sendRedirect("Message.jsp");
			}
		}
	}

}
