package setFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.User;

public class filterLogin implements Filter {

	@Override
	public void doFilter(ServletRequest request1, ServletResponse response1, FilterChain chain)
			throws IOException, ServletException {
		//Cart.jps Check.jsp 未登录不能进入
		HttpServletRequest request = (HttpServletRequest)request1;
		HttpServletResponse response = (HttpServletResponse)response1;
		HttpSession session = ((HttpServletRequest)request).getSession();
		User user = (User)session.getAttribute("user");
		if(user == null){
			System.out.println("1");
			response.sendRedirect("login.jsp");
		}
		else{
			chain.doFilter(request1, response1);
		}
		
	}

}
