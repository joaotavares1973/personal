package br.com.bpss.hg.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import br.com.bpss.hg.domain.Usuario;

public class RequestsInterceptor extends HandlerInterceptorAdapter {

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
//		if(request.getSession().getAttribute("Operador") == null 
//				&& !"/hedgeaccount/login.do".contains(request.getRequestURI())){
//			response.sendRedirect("/");
//			return false;
//		}else{
//			return true;
//		}
		
		
		
		return true;

	}
	
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
		if(request.getSession().getAttribute("Usuario") != null)
			request.setAttribute("login", ((Usuario)request.getSession().getAttribute("Usuario")).getCdUsuario());
	}
	
}
