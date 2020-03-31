package com.zp.common;
import javax.servlet.http.HttpServletRequest;
/**
 * 获取用户登录的ip地址
 * @author zp
 * <p>Description: </p>  
 * <p>Copyright: Copyright (c) 2019</p>
 */
public class IpUtils {
	public static String getIpAddr(HttpServletRequest request) {
      String ip = request.getHeader("x-forwarded-for");
      if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
          ip = request.getHeader("Proxy-Client-IP");
       }
     if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getHeader("WL-Proxy-Client-IP");
     }
     if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
         ip = request.getRemoteAddr();
     }
     if (ip.equals("0:0:0:0:0:0:0:1")) {
         ip = "本地";
     }
        return ip;
     }
}
