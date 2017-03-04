package com.lyq.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;


public class CharaactorFilter implements Filter {

	String encoding = null;

	public CharaactorFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		System.out.println("初始化");
		encoding = fConfig.getInitParameter("encoding");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		if (encoding != null) {
			request.setCharacterEncoding(encoding);
			response.setContentType("text/html;charset="+encoding);
		}

		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		encoding = null;
	}

}
