package tour.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginCheckInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)throws Exception {
		HttpSession session = request.getSession();
		
		if((String)session.getAttribute("userId") == null) {
			response.sendRedirect("/login/loginFail");
			return false;
		}
		else {
			session.setMaxInactiveInterval(600);
			return true;
		}
	}
}
