package com.zp.exception;
import java.util.List;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import com.zp.vo.ResultVo;
@ControllerAdvice //该注解定义全局异常处理类
@ResponseBody
public class ValidException {
    	@ExceptionHandler(BindException.class)
	    public ResultVo handlerBindException(BindException exception) {
    		System.err.println("执行bindException");
	        return handlerNotValidException(exception);
	    }
    	 
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public ResultVo handlerArgumentNotValidException(MethodArgumentNotValidException exception) {
	    	System.err.println("执行MethodArgumentNotValidException");
	        return handlerNotValidException(exception);
	    }
	    
		@ExceptionHandler(Exception.class)
		public ResultVo handlerNotValidException(Exception exception) {
			System.err.println("执行Exception");
			BindingResult result;
			if(exception instanceof BindException) {
	             BindException bindException = (BindException) exception;//强制转一下
	             result=bindException.getBindingResult();
			} else {
	            MethodArgumentNotValidException methodArgumentNotValidException = (MethodArgumentNotValidException) exception;
	            result = methodArgumentNotValidException.getBindingResult();
	        }
			if(result.hasErrors()) {
				  List<FieldError> fieldErrors = result.getFieldErrors();
				  return new ResultVo(false,fieldErrors.get(0).getDefaultMessage());
			}
			return new ResultVo(true,"无异常");
		}
		
}
