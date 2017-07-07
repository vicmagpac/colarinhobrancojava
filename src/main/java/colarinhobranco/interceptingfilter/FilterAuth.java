package colarinhobranco.interceptingfilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter(urlPatterns="/FrontController")
public class FilterAuth implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {

		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		
		HttpSession session = req.getSession();
		String usuarioLogado = (String) session.getAttribute("login");
		
		
		String except = ((HttpServletRequest) request).getParameter("ApplicationController");
		System.out.println(usuarioLogado + "tt");
		if (except.equals("Login") || except.equals("Auth")) {
			chain.doFilter(request, response);
		} else {
		
			if (usuarioLogado == null) {
				HttpServletResponse httpResponse = (HttpServletResponse) response;
				httpResponse.sendRedirect("/colarinhobranco/FrontController?ApplicationController=Login");		
				
			} else {
				
				chain.doFilter(request, response);	
			}
			
		}
	
		
		
	}

	@Override
	public void destroy() {
		
	}

}
