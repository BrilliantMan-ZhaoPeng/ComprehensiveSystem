package com.zp.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.intercepter.Token;
@Controller
@RequestMapping("/others")
public class OthersController {
	
	//跳转到others的界面
	@RequestMapping
	@Token(generate = true)
	public String toOthers(HttpServletRequest request,HttpServletResponse response) {
		 return "body/others";
	}
	
   	//获取当前用户登录的ip地址，浏览器信息，以及sessionid的信息
 	 @GetMapping("/getIps")
	 @ResponseBody
	 public String getIpAndBrowerAndSessionId(HttpServletRequest request) {
        StringBuilder stringBuilder=new StringBuilder();
        //获取浏览器的信息
        String browerInfo = request.getHeader("User-Agent");
        //获取当前访问的ip地址
        String loginIp = request.getHeader("X-Forwarded-For");
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            loginIp = request.getHeader("X-Real-IP");
        }
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            loginIp = request.getHeader("Proxy-Client-IP");
        }
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            loginIp = request.getHeader("WL-Proxy-Client-IP");
        }
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            loginIp = request.getHeader("HTTP_CLIENT_IP");
        }
        if (loginIp == null || loginIp.length() == 0 || "unknown".equalsIgnoreCase(loginIp)) {
            loginIp = request.getRemoteAddr();
        }
        //获取用户的SessionId
        String sessionId = request.getSession().getId();
        stringBuilder.append("ip:"+loginIp+"----浏览器:"+browerInfo+"-----sessionId:"+sessionId);        
        return stringBuilder.toString();
	 }
 	 
 	 
 	 @PostMapping("/submit")
 	 @Token(remove = true)
 	 public String toSubmit(HttpServletRequest request,HttpServletResponse response) {
 		 System.err.println("执行提交的方法");
 		 return "success";
 	 }
 	 
}
