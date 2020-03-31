package com.zp.modules.account.controller;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.apache.poi.hslf.dev.UserEditAndPersistListing;
import org.apache.poi.util.PackageHelper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.github.pagehelper.PageInfo;
import com.zp.modules.account.controller.vo.RoleVo;
import com.zp.modules.account.controller.vo.UserVo;
import com.zp.modules.account.entity.Resource;
import com.zp.modules.account.entity.Role;
import com.zp.modules.account.entity.User;
import com.zp.modules.account.service.AccountService;
import com.zp.vo.ResultVo;
@Controller
@RequestMapping("/shiro")
public class AccountController {
	@Autowired
	private AccountService accountService;
	
	//跳转到主页
	@RequestMapping
	public String toIndex(Model model) {
		//得到该用户能访问的资源
		return "account/index";
	}
	
	
	@RequestMapping("/relogin")
    //重定向到登录界面
	public String redirectloginPage(RedirectAttributes  redirectAttributes) {
		return "redirect:/shiro/login";
	}

	
	//跳转到登录界面
	@RequestMapping("/login")
	public String loginPage() {
		return "account/login";
	}

	//注册界面
	@RequestMapping("/register")
	public  String registerPage() {
		return "account/register";
	}
	
	//注册的实现
	@PostMapping(value = "/doRegister",produces = "application/json;charset=utf-8")
	@ResponseBody
	public ResultVo register(@ModelAttribute User user) {
		System.err.println("user"+user);
		//return new ResultVo(true,"asdasd");
		return accountService.addUser(user);
	}

	@PostMapping(value="/doLogin")
	@ResponseBody
	public ResultVo doLogin(@ModelAttribute User user) {////前台传来的不是json数据，，，比如一个表单的数据
		return accountService.doLogin(user);
	}
	
	/**
	 * 用户退出登录
	 */
	@RequestMapping("/logout")
	public String logout() {
		Subject subject = SecurityUtils.getSubject();
		subject.logout();
		return "redirect:/shiro/relogin";
	}

	/**
	 * 跳转到用户管理
	 */
	@RequestMapping("/users")
	public String toUsers(@RequestParam(value = "async",defaultValue = "true")boolean async,@RequestParam(value = "pageNum",defaultValue = "1")int pageNum
			,@RequestParam(value = "pageSize",defaultValue = "10")int pageSize,Model model) {
		System.err.println(pageNum+" "+pageSize);
		PageInfo<User> pageInfo = accountService.getAllUsers(pageNum, pageSize);
		model.addAttribute("users",pageInfo.getList());
		model.addAttribute("page",pageInfo);
		return async==true?"/account/users":"/account/users::#mainContainer";
	}

	/**
	 * 传信息到user编辑界面
	 * @param userId
	 * @return
	 */
	@RequestMapping(value = "/users/{id}",produces = "application/json;charset=utf-8",method = RequestMethod.GET)
	public String toUser(@PathVariable("id")int userId,Model model) {
		User userByUserId = accountService.getUserByUserId(userId);
		List<Role> allRoles = accountService.getAllRoles();/////获取系统所有的角色
		List<Role> userRoles=userByUserId.getRoles();////获取当前用户所拥有的角色 
		//////////////////////这里为了前端的操作，，处理去重的操作
		Iterator<Role> iterator = allRoles.iterator();
		while(iterator.hasNext()) {
			Role next = iterator.next();
			for (Role role : userRoles) {
				 if(role.getRoleId()==next.getRoleId()) {
					 iterator.remove();
				 }
 			}
		}
		/////////////////////这是去过重的
		model.addAttribute("user",userByUserId);
		model.addAttribute("roles",allRoles);
		return "account/edit";
	}
	
	
	@DeleteMapping("/users/{id}")
	@ResponseBody
	public void removeUser(@PathVariable("id") int userId) {
		System.err.println("------------------"+userId);
		User user=new User();
		user.setUserId(userId);
		user.setRemoveState(1);
		accountService.removeUser(user);
	}
	
	//修改数据
	@ResponseBody
	@PutMapping(value = "/users/",consumes = "application/json;charset=utf-8")
	public ResultVo editUser(@RequestBody UserVo userVo) {
		return accountService.updateUser(userVo);
	}
	
	
	//跳转到角色管理界面
	@RequestMapping("/roles")
	public String toRoles(Model model) {
	    model.addAttribute("roles",accountService.selAllRoles());
		return "/account/roles";
	}
	
	
	@GetMapping("/roles/{id}")
	public String  toEditRole(@PathVariable("id") int id,Model model) {
		List<Resource> allResource = accountService.selAllResource();
		Role role;
        if(id==0){//执行增加
          role=new Role(0);
        }else {
        	role = accountService.selRoleById(id);
        	List<Resource> resources = role.getResources();
        	Iterator<Resource> iterator = allResource.iterator();
        	while(iterator.hasNext()) {
        		Resource next = iterator.next();
        		for (Resource resource : resources) {
        			if(next.getResourceId()==resource.getResourceId()) {
        				iterator.remove();
        			}
        		}
        	}
        }
		model.addAttribute("allResource",allResource);
		model.addAttribute("role",role);
		return "account/editRole";
	}
	
	
	@PutMapping(value = "/roles")
	@ResponseBody
	public ResultVo doEditRole(@RequestBody RoleVo roleVo) {
		return accountService.saveRole(roleVo);
	}
    
	@PostMapping("/roles/check")
	@ResponseBody
	public boolean checkRoleName(@RequestParam("newRoleName")String newRoleName,@RequestParam("oldRoleName")String oldRoleName) {
		 return accountService.checkroleName(newRoleName,oldRoleName); 
	}
	
	
	@DeleteMapping("/roles/{roleId}")
	@ResponseBody
	public boolean delRole(@PathVariable("roleId")int roleId) {
		return accountService.delRole(roleId);
	}
	
	//用户名重名验证
	@ResponseBody
	@GetMapping("/check")
	public boolean checkUsername(@RequestParam("userName")String userName) {
		return accountService.checkuserName(userName);
	}
	
	@RequestMapping("/error")
	public String toerror() {
		return "error/404";
	}
	
	//跳转到资源管理 界面
	@RequestMapping("/resource")
	public  String toResource(Model model) {
		model.addAttribute("resources",accountService.selAllResource());
		return "/account/resources";
	}
}
