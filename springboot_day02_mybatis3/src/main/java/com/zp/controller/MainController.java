package com.zp.controller;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zp.common.IpUtils;
import com.zp.exception.MyException;
import com.zp.vo.ResultVo;
@Controller
public class MainController {
	  @RequestMapping("/index")
	  public String toIndex() {
		  return "index";
	  }
	  
	  @RequestMapping("/error/500")
	  public String toError(Model model) {
		  model.addAttribute("errorMsg","兄弟，，，有错哦！！！");
		  return "error";
	  }
	 
	  
	  @RequestMapping("/home")
	  public String tetsError() {
		  throw new MyException("1000","错啦");
	  }
	  
	  
	  /*@RequestMapping("/404")
	  public String to404() {
		  return "error/404";
	  }
	  */
	  
	  @RequestMapping("/word")
	  @ResponseBody
	  public ResultVo isSensitiveWord(@RequestParam("keyword")String keyword,HttpServletRequestWrapper request) {
            return new ResultVo(true,keyword);
	  }
}
