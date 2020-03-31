package com.zp.filer;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import com.zp.common.SensitiveWords;
@WebFilter(filterName = "parameterFilter",urlPatterns = "/**")
public class ParameterFilter implements Filter{
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
        HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletRequestWrapper httpServletRequestWrapper = new HttpServletRequestWrapper(httpRequest) {
        	 @Override
 			public String[] getParameterValues(String name) {
 				String[] values = httpRequest.getParameterValues(name);
 				if (values != null && values.length > 0) {
 					for(int i=0;i<values.length;i++) {
 						values[i] = new SensitiveWords().isSensitiveWords(values[i]);
 					}
 					return values;
 				}
 				return super.getParameterValues(name);
 			}
        };
        chain.doFilter(httpServletRequestWrapper, response);
	}	
}
