package com.zp;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.MockitoFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.validation.BindException;

import com.github.pagehelper.PageInfo;
import com.zp.modules.account.entity.Resource;
import com.zp.modules.account.entity.Role;
import com.zp.modules.account.entity.User;
import com.zp.modules.account.repository.AccountRepository;
import com.zp.modules.account.service.AccountService;
@SpringBootTest
@PropertySource("classpath:application.properties")//如果是application.properties，就不用写
class SpringbootDay02Mybatis3ApplicationTests {
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountService accountService;
	@Autowired
	private Environment env;
	@Value("${aaa}")
	private String value;
	@Test
	public void  test1() {
		PageInfo<User> allUsers = accountService.getAllUsers(1,3);
		int[] navigatepageNums = allUsers.getNavigatepageNums();
		for(int i=0;i<navigatepageNums.length;i++) {
			System.err.print(navigatepageNums[i]+" ");
		}
		System.err.println(allUsers.getNavigatePages());
		System.err.println(allUsers.getList().size());
	}

	@Test
	public void test2() {
		System.err.println(env.getProperty("pagehelper.helper-dialect"));
	}
	
	@Test
	public void test3() {
		int insRole = accountRepository.insRole(new Role(0,"dasdasdasdas"));
		System.err.println(insRole);
	}
}