package com.zp.controller;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.zp.common.ExcelUtils;
import com.zp.modules.account.entity.User;
import com.zp.service.UserService;
import com.zp.vo.ResultVo;
@Controller
@RequestMapping("/excel")
public class UserExcelController {
	@Autowired
	private UserService userService;
	@RequestMapping
	public ModelAndView toUserPage(Model model) {
		List<User> selAllUsers = userService.selAllUsers();
		model.addAttribute("users",selAllUsers);
		return new ModelAndView("body/user","userModel",model);
	}
	
    //导出excel
	@RequestMapping(value = "/export",method = RequestMethod.GET)
	public void exportExcel(HttpServletResponse response) throws IOException {
		  List<User> users =userService.selAllUsers();
		  ExcelUtils.exportExcel(users,"员工信息表","员工信息",User.class,"员工信息",response);
	}
	
	
	//导入Import
	@RequestMapping(value = "/import",method = RequestMethod.POST,consumes = "multipart/form-data",produces= "application/json;charset=utf-8")
	@ResponseBody
	public ResultVo importExcel(@RequestParam("excelFile")MultipartFile file) throws IOException {
		if(file.isEmpty()) {
			return new ResultVo(false,"选择为空");
		}else {
			List<User> users=ExcelUtils.importExcel(file,User.class);
			List<User> errorUsers=new ArrayList<User>();
			for (User user : users) {
					User selUserByUserName = userService.selUserByUserName(user.getUserName());
					if(selUserByUserName==null) {
						userService.insUser(user);
					}else {
						errorUsers.add(user);
					}
			}
			return new ResultVo(true,"上传成功",errorUsers);
		}
	}
}
