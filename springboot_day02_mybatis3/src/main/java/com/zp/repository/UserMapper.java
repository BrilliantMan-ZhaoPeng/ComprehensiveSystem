package com.zp.repository;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.zp.modules.account.entity.User;
@Repository
@Mapper
public interface UserMapper {
	//查询所有的User用户
	//@Select("select * from m_user")
    public List<User> selAll();
    //根据user进行查找
    public User selUserByUserName(@Param("userName")String userName);
    //插入User
    public int insUserByUser(User user);
}
