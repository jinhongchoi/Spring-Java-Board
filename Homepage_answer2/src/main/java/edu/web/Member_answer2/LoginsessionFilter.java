package edu.web.Member_answer2;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginsessionFilter extends HttpFilter implements Filter {
       
 
    public LoginsessionFilter() {
        super();
        // TODO Auto-generated constructor stub
    }


	public void destroy() {
		
	}


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String userid =(String) session.getAttribute("userid");
		if(userid ==null) {
			HttpServletResponse res = (HttpServletResponse) response;
			res.sendRedirect("/Homepage/login.jsp");
			return; // 정료 -> if문에서 return을 쓰지않으면 코드가 밑에까지 가버린다! 
		}
		
		chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
