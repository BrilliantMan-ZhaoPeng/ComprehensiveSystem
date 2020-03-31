package com.zp.intercepter;
import java.lang.reflect.Method;
import java.util.UUID;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import com.alibaba.druid.util.StringUtils;
/**
   * 防止页面重复提交的Intercepter
 * @author 25045
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>
 */
@Component
public class AvoidDuplicateSubmissionInterceptor extends HandlerInterceptorAdapter {
	private static final String TOKEN="token";
	
	public AvoidDuplicateSubmissionInterceptor(){
		
	}

	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
				throws Exception {
		    System.out.println(">>>MyInterceptor1>>>>>>>在请求处理之前进行调用（Controller方法调用之前）");
     		response.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
	        response.setHeader("Access-Control-Allow-Methods", "*");
	        response.setHeader("Access-Control-Allow-Credentials", "true");
	        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,content-type");
	        System.err.println("------------------>:已完成跨域处理");
		
		if(handler instanceof HandlerMethod) {
			 Method method = ((HandlerMethod) handler).getMethod();
			 System.err.println("拦截的方法名："+method.getName());
			 Token tokenAnnotation = method.getAnnotation(Token.class);
			 if(tokenAnnotation != null) {
				 HttpSession session = request.getSession();
				 //创建新的表单提交令牌token,防止表单重复提交
				 boolean generate = tokenAnnotation.generate();
				 if(generate) {
					 String formToken = UUID.randomUUID().toString();
					 session.setAttribute(TOKEN,formToken);
					 System.err.println("注解叫我们创建token");
					 return true;
				 }
				 
				 boolean remove = tokenAnnotation.remove();
				 if(remove) {
					 System.err.println("注解叫我们删除token");
					 if(isRepeatSubmit(request)){
						 System.err.println("重复提交了，需要制止。。。。");
						 //并且跳转到错误页面
						 request.setAttribute("errorMsg","兄弟，真的不要给我重复提交了，没用的哈，你不累的吗？？？？嗯哼唧！！！");
						 request.getRequestDispatcher("/error").forward(request, response);
						 return false;
					 }
					 session.removeAttribute(TOKEN);
				 }
			 }
		}else {
			return super.preHandle(request, response, handler);
		}
		    return true;
		}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		super.postHandle(request, response, handler, modelAndView);
	}
	
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
	
	/**
	  * 当获取session的中token为空表示是重复提交
	  *当获取获取表单域中的token为空表示是重复提交
	  *当上面两个都存在，但是equals为false表示是重复提交
	  *当且仅当session的token与表单域中的token相等才是正确的
     * @param request
	 * @return
	 */
	private boolean isRepeatSubmit(HttpServletRequest request) {
        //session中token
        String token = (String) request.getSession().getAttribute(TOKEN);
        if (StringUtils.isEmpty(token)) {
            return true;
        }
        
        //请求头中获取token
        String reqToken = request.getHeader(TOKEN);
        if (StringUtils.isEmpty(reqToken)) {
            //请求参数request中获取token
            reqToken = request.getParameter(TOKEN);
            if (StringUtils.isEmpty(reqToken)) {
                return true;
            }
        }
        //对比session与前端传递过来的token是否相等
        if (!token.equals(reqToken)) {
        	System.err.println("表名是重复提交");
            return true;
        }
        return false;
     }
}
