package com.zp.repository;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import com.zp.pojo.Student;
@Repository
@Mapper
public interface StudentMapper {
	 /**
	  * 查询所有的数据
	  * @return
	  */
     List<Student> selAll();
}
