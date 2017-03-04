package SaveServlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.lyq.bean.service.M_Service;



@WebServlet(urlPatterns ="/Update_Pwd_Servlet")//注释配置文件
public class Update_Pwd_Servlet extends HttpServlet {	
	private static final long serialVersionUID = 1L;		
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {								
				HttpSession session = request.getSession();
				String sort = (String) session.getAttribute("SORT");//获得用户更改后的信息
				String uname =(String) session.getAttribute("UNAME");														
				String password = request.getParameter("password");
				
				String bool=new M_Service().getUpdatePwd(sort, uname, password);
				if(bool!=null){		
					request.getSession().setAttribute("message", "密码修改成功！");									
				}
				else{					
					request.getSession().setAttribute("message", "密码修改失败！");											
				}
				request.getSession().setAttribute("url", "jsp/UpdatePwd.jsp");
				response.sendRedirect("Message.jsp");													
	}       
}

