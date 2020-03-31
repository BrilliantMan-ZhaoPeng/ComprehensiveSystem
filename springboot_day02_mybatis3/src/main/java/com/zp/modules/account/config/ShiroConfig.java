package com.zp.modules.account.config;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
/**
 * @author 25045
 * <p>Description:
 *  * shiro配置类，配置如下bean
 * securityManager ---- shiro核心组件之一
 * ShiroFilterFactoryBean ---- shiro核心组件之一
 * ShiroDialect ---- shiro方言，支持thymeleaf标签
 * DefaultAdvisorAutoProxyCreator ---- 支持shiro注解
 * AuthorizationAttributeSourceAdvisor ---- 开启shiro注解
 * </p>  
 * <p>Copyright: Copyright (c) 2019</p>
 */
@Configuration
public class ShiroConfig {
	@Autowired
    private MyRealm myRealm;
	/**
	 * 注册securityManager
	 * @return
	 */
	@Bean
	public DefaultWebSecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myRealm);
		//增加记住我功能
		securityManager.setRememberMeManager(rememberMeManager());
		// 添加Session管理
	//	securityManager.setSessionManager(sessionManager());
		return securityManager;
	}
	
	/**
	 * --记住我之cookie管理器
	 */
	@Bean
	public CookieRememberMeManager rememberMeManager() {
		    CookieRememberMeManager cookieRememberMeManager=new CookieRememberMeManager();
		   //
		    byte[] cipherKey = Base64.decode("wGiHplamyXlVB11UXWol8g==");
		    cookieRememberMeManager.setCipherKey(cipherKey);
		    cookieRememberMeManager.setCookie(rememberMeCookie());
		    return cookieRememberMeManager;
	}
	
	
	/**
	 * --记住我之SimpleCookie
	 */
	@Bean
	public SimpleCookie rememberMeCookie() {
	    //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
	    SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
	    //如果httyOnly设置为true，则客户端不会暴露给客户端脚本代码，
	    //使用HttpOnly cookie有助于减少某些类型的跨站点脚本攻击；
	    simpleCookie.setHttpOnly(true);
	    //记住我cookie生效时间,单位是秒
	    simpleCookie.setMaxAge(30 * 24 * 60 * 60);
	    return simpleCookie;
	}
	
	
	
	@Bean
	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager());
		shiroFilterFactoryBean.setLoginUrl("/shiro/login");
		shiroFilterFactoryBean.setSuccessUrl("/shiro/");
		shiroFilterFactoryBean.setUnauthorizedUrl("/shiro/error");
		
		////放行相应的资源
		Map<String, String> map = new LinkedHashMap<String, String>();
		map.put("/static/**", "anon");
		map.put("/js/**", "anon");
		map.put("/css/**", "anon");
		map.put("/shiro/login", "anon");
		map.put("/shiro/doLogin", "anon");
		map.put("/shiro/register", "anon");
		map.put("/shiro/doRegister", "anon");
		map.put("/shiro/check", "anon");
		map.put("/excel/**", "anon");
		map.put("/index/**", "anon");
		map.put("/country/**", "anon");
		map.put("/file/**", "anon");
		map.put("/others/**", "anon");
		map.put("/shiro/**", "user");//使用记住我的功能
		shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
		return shiroFilterFactoryBean;
	}
	
	/**
	 * 注册方言，让thymeleaf支持shiro标签
	 * @return
	 */
	@Bean
	public ShiroDialect shiroDialect() {
		return new ShiroDialect();
	}
	
	@Bean
	public FormAuthenticationFilter formAuthenticationFilter(){
	    FormAuthenticationFilter formAuthenticationFilter = new FormAuthenticationFilter();
	    //对应前端的checkbox的name = rememberMe
	    formAuthenticationFilter.setRememberMeParam("rememberMe");
	    return formAuthenticationFilter;
	}

	
	/**
	 * --自动代理类，支持Shiro的注解
	 */
	@Bean
	@DependsOn({"lifecycleBeanPostProcessor"})
	public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator(){
		DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
		advisorAutoProxyCreator.setProxyTargetClass(true);
		return advisorAutoProxyCreator;
	}
	
	 /**
     * --开启Shiro的注解
     */
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(){
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager());
		return authorizationAttributeSourceAdvisor;
	}
	
	
	/**
	 * 1、session 管理，去掉重定向后Url追加SESSIONID
	 * 2、shiro默认Cookie名称是JSESSIONID，与servlet(jetty, tomcat等默认JSESSIONID)冲突，
	 * --我们需要为shiro指定一个不同名称的Session id，否则抛出UnknownSessionException: 
	 * There is no session with id异常
	 */
	@Bean
	public DefaultWebSessionManager sessionManager() {
		DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
		sessionManager.setSessionIdUrlRewritingEnabled(false);
		sessionManager.setSessionIdCookie(rememberMeCookie());
		return sessionManager;
	}
}
