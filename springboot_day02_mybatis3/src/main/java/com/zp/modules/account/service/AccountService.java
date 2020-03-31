package com.zp.modules.account.service;
import java.util.Date;
import java.util.List;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.modules.account.controller.vo.RoleVo;
import com.zp.modules.account.controller.vo.UserVo;
import com.zp.modules.account.entity.Resource;
import com.zp.modules.account.entity.Role;
import com.zp.modules.account.entity.User;
import com.zp.modules.account.repository.AccountRepository;
import com.zp.modules.account.utils.MD5Util;
import com.zp.vo.ResultVo;
@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepository;
	
	public User getUserByUsername(String userName) {
		return accountRepository.getUserByUsername(userName);
	}
	
	public ResultVo doLogin(User user) {
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(user.getUserName(),MD5Util.getMD5(user.getPassword()));
			//设置记住密码
			usernamePasswordToken.setRememberMe(user.isRememberMe());
			subject.login(usernamePasswordToken);
			subject.checkRoles();
		}catch (Exception e) {
			return new ResultVo(false,"password or username is not true.");
		}
		return new ResultVo(true,"success");
	}
	
	
	public List<Role> getRolesByUserId(int userId){
		return accountRepository.getRolesyuserId(userId);
	}
	
	public List<Resource> getResoucesByUserId(int userId){
		return accountRepository.getResourcesByRoleId(userId);
	}
	
	
	//pageHelper实现分页
	public PageInfo<User> getAllUsers(int pageNum,int pageSize){
		  PageHelper.startPage(pageNum,pageSize,true);
		  List<User> selAllUser = accountRepository.selAllUser();
		  PageInfo<User> pageInfo=new PageInfo<User>(selAllUser);
		  return pageInfo;
	}
	
	@Transactional
	public User getUserByUserId(int userId) {
		User user = accountRepository.selUserByUserId(userId);
		if(user!=null) {
			List<Role> roles = accountRepository.getRolesyuserId(user.getUserId());
			user.setRoles(roles);
		}
		return user;
	}
	
	public List<Role> getAllRoles(){
		List<Role> allRoles = accountRepository.getAllRoles();
		return allRoles;
	}

	//修改增加的方法
	@Transactional
	public ResultVo updateUser(UserVo uservo) {
		User user = accountRepository.selUserByUserId(uservo.getUserId());
		try {
			if(!user.getUserName().equals(uservo.getUserName())) {//证明修改了
				User userByUsername = accountRepository.getUserByUsername(uservo.getUserName());
				if(null!=userByUsername) {//说明重名了
					return new ResultVo(false,"名字已被别人占用");
				}
			}
			user.setPassword(MD5Util.getMD5(uservo.getPassword()));
			user.setUserName(uservo.getUserName());
			///////修改密码
			accountRepository.upUser(user);
			////修改角色，，增加权限
			///先删除之前所有的权限
			accountRepository.delUserRoleByUserId(uservo.getUserId());
			int[] rolesId = uservo.getRoles();
			////增加现在的权限
			for (int i = 0; i < rolesId.length; i++) {
				accountRepository.insUserRole(uservo.getUserId(),rolesId[i]);
			}
			return new ResultVo(true,"修改成功！！！");
		}catch (Exception e) {
			return new ResultVo(false,"出现未知错误，请稍后重试！！！");
		}
	}
	
	
	//删除user的实现
	public void removeUser(User user) {
        accountRepository.upUser(user);		
	}

	//分页插件的实现
	public PageInfo<User> getAllUserAndPage(){
		  PageHelper.startPage(1,3);
		  List<User> selAllUser = accountRepository.selAllUser();
		  PageInfo<User> pageInfo=new PageInfo<User>(selAllUser);
		  return pageInfo;
	}

	//检查username
	public boolean checkuserName(String userName) {
		User userByUsername = accountRepository.getUserByUsername(userName);
		if(userByUsername==null){
			return false;
		}else {
			return true;
		}
	}

	
	//注册实现
	public ResultVo addUser(User user) {
		user.setCreateDate(new Date());
		user.setPassword(MD5Util.getMD5(user.getPassword()));
		int insUser = accountRepository.insUser(user);
		if(insUser==1) {
            return new ResultVo(true,"注册成功！！！");			
		}
		return new ResultVo(false,"注册失败！！！");
	}
	
	//查询所有的Roles
	public List<Role> selAllRoles(){
		return accountRepository.selAllRoles();
	}
	
	//查询所有的Resource
	public List<Resource> selAllResource(){
		return accountRepository.selAllRsesources();
	}
	
	//根据id查询role
	public Role selRoleById(int id) {
		return accountRepository.selRoleById(id);
	}
	
	
	//////check检查roleName是否重名的操作
	public  boolean checkroleName(String newRoleName,String oldRoleName) {
		String selRoleNameByroleName = accountRepository.selRoleNameByroleName(newRoleName,oldRoleName);
		if("".equals(selRoleNameByroleName)||selRoleNameByroleName==null) {//说明是合法的
			 return true;
		}else {
			return false;
		}
	}
	
	@Transactional
	//进行修改,保存 role
	public  ResultVo saveRole(RoleVo roleVo) {
		  Role role=new Role();
		  role.setRoleId(roleVo.getRoleId());
		  role.setRoleName(roleVo.getRoleName());
		  int roleId=roleVo.getRoleId();
		  int[] resources = roleVo.getResources();
		  if(roleId==0){//执行保存
			  try {
				  accountRepository.insRole(role);
				  int newRoleId = accountRepository.selMaxId();//得到当前插入role返回的id
				  for (int resourceId : resources) {
					  accountRepository.insResourceByRoleIdAndResourceId(newRoleId, resourceId);
				  } 
				 return new ResultVo(true,"增加成功！！！");
			} catch (Exception e) {
				 return new ResultVo(false,"增加失败！！！");
			}
		  }else {//执行修改
			  try {
				  accountRepository.upRole(role);//先修改role
				  accountRepository.delResourceByRoleId(role.getRoleId());
				  for (int resourceId : resources) {
					  accountRepository.insResourceByRoleIdAndResourceId(role.getRoleId(), resourceId);
				  }
			  } catch (Exception e) {
				  return new ResultVo(false,"系统繁忙，请稍后重试！！！");
			  }
			  return new ResultVo(true,"修改成功！！！");
		  }
	}
	
	@Transactional
	public boolean delRole(int roleId) {
		accountRepository.delRoleByRoleId(roleId);
		accountRepository.delResourceByRoleId(roleId);
		return true;
	}
}
