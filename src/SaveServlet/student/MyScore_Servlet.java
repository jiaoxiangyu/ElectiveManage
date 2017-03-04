package SaveServlet.student;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lyq.bean.Elective;
import com.lyq.bean.service.E_Service;

@WebServlet("/MyScore_Servlet")
public class MyScore_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String sNo = (String) request.getSession().getAttribute("UNAME");
		List<Elective> list = new ArrayList<Elective>();
		list = new E_Service().seekScore(sNo, list);// 查询选课成绩
		request.setAttribute("list", list);
		if (list.size() > 0) {
			request.getRequestDispatcher("/jsp/student/s/MyScore.jsp").forward(request, response);
		} else {
			request.getSession().setAttribute("message", "你还没有选课！");
			request.getSession().setAttribute("url", "ElectCourse_Servlet?id=seekall");
			response.sendRedirect("Message.jsp");
		}
	}
}
