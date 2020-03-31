package com.zp.controller;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import com.zp.vo.ResultVo;
@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class ExceptionHandlerReslover{
	 @ExceptionHandler(value = MaxUploadSizeExceededException.class)
	 @ResponseBody
     public ResultVo exception1() {
    	 return new ResultVo(false, "上传失败,文件上传过大");
     }
	 
	
	 /*@ExceptionHandler(value = MyException.class)
	 public Object errorHandler(MyException ex,Model model) {
		 model.addAttribute("errorMsg","失败了哦");
 		 return "error";
	 }*/
}
