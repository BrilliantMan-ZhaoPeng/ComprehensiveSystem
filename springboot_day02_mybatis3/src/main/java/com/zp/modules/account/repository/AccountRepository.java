package com.zp.modules.account.repository;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.zp.modules.account.entity.Resource;
import com.zp.modules.account.entity.Role;
import com.zp.modules.account.entity.User;
@Repository
@Mapper//作用是可以不用写xml文件，直接使用注解sql语句就能执行插查询
public interface AccountRepository {
	//根据用户名和密码去查询账户
   @Select("select * from m_user where user_name=#{userName} and password=#{password}")
   public User getUserByUserNameAndPassword(User user);
   //根据用户名查询用户
   @Select("select * from m_user where user_name=#{userName}")
   public User getUserByUsername(@Param("userName")String userName);
   //根据用户id查询角色信息
   @Select("select m_role.role_id,m_role.role_name from m_role inner join m_user_role on m_user_role.role_id=m_role.role_id inner join m_user on m_user.user_id=m_user_role.user_id where m_user.user_id=#{userId}")
   public List<Role> getRolesyuserId(@Param("userId")int userId);
   
   //根据角色id查询角色所拥有的资源信息
   @Select("select m_resource.resource_id, m_resource.resource_uri, m_resource.resource_name from m_resource inner join m_role_resource on m_resource.resource_id=m_role_resource.role_resource_id inner join m_role on m_role.role_id=m_role_resource.role_id where m_role.role_id=#{roleId}")
   public List<Resource> getResourcesByRoleId(int roleId);
   
   //查询所有的用户
   public List<User> selAllUser();

   //根据userId查询User
   public User selUserByUserId(@Param("userId")int userId);
   //查询所有的User
   
   @Select("select * from m_role")
   public List<Role> getAllRoles();
   
   
   //修改用户账号和密码
   public int upUser(User user);
   
   //根据用户Id删除角色用户中间表
   @Delete("delete from m_user_role where user_id=#{userId}")
   public int delUserRoleByUserId(int userId);
   
   //插入到用户角色中间表
   @Insert("insert into m_user_role (role_id,user_id) values(#{roleId},#{userId})")
   public int insUserRole(@Param("userId")int userId,@Param("roleId")int roleId);
   
   @Insert("insert into m_user (user_name,password,create_date) values(#{userName},#{password},#{createDate})")
   public int insUser(User user);
   
   ///查询所有的role信息，，，
   public List<Role> selAllRoles();
   
   ////查询所有的Resource
   @Select("select * from m_resource")
   public List<Resource> selAllRsesources();
   
   //根据roleid进行查询
   public Role selRoleById(@Param("id")int id);
   
   //根据roleName查询值
   @Select("select role_name from m_role where role_name=#{newRoleName} and role_name!=#{oldRoleName}")
   public String selRoleNameByroleName(@Param("newRoleName")String newRoleName,@Param("oldRoleName")String oldRoleName);
   
   //修改role的值
   @Update("update m_role set role_name = #{roleName} where role_id=#{roleId}")
   public int upRole(Role role);
   
   //删除一个角色的所有资源信息
   @Delete("delete from m_role_resource where role_id=#{roleId}")
   public int delResourceByRoleId(int  roleId);
   
   //增加角色的资源
   @Insert("insert into m_role_resource(role_id,resource_id) values(#{roleId},#{resourceId})")
   public int insResourceByRoleIdAndResourceId(@Param("roleId")int roleId,@Param("resourceId")int resourceId);
   
   //删除根据roleId   role
   @Delete("delete from m_role where role_id=#{roleId}")
   public int delRoleByRoleId(int roleId);
   
   //插入role,,并且返回当前role的id
   @Insert("insert into m_role (role_id,role_name) values(default,#{roleName})")
   public int insRole(Role role);
   
   //查询最大的id
   @Select("select max(role_id) from m_role")
   public int selMaxId();
   
   //查询所有的resource
   @Select("select * from m_resource")
   public List<Resource> selAllResource();
}