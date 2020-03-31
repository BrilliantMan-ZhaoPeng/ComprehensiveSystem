package com.zp.config;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.zp.filer.ParameterFilter;
import com.zp.intercepter.AvoidDuplicateSubmissionInterceptor;
@Configuration
public class MyConfig implements WebMvcConfigurer{
	//配置视图解析
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
    	registry.addViewController("/index").setViewName("index");//前面的参数为访问的路径名，，，第二个参数为，html文件名
    	registry.addViewController("/").setViewName("index");
    }
    
    //配置过滤器
	@Bean
	public FilterRegistrationBean<ParameterFilter> parameterFilter() {
		FilterRegistrationBean<ParameterFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setFilter(new ParameterFilter());
		return filterRegistrationBean;
	}
	
	//配置拦截器
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(getTokenInterceptor())
		.addPathPatterns("/others/**");
		WebMvcConfigurer.super.addInterceptors(registry);
	}
	
	@Bean
	public HandlerInterceptor getTokenInterceptor() {
		return new AvoidDuplicateSubmissionInterceptor();
	}
}   
 