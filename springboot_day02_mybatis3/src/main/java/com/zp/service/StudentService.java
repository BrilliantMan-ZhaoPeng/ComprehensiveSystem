package com.zp.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zp.pojo.Student;
import com.zp.repository.StudentMapper;
@Service
public class StudentService {
	@Autowired
	private StudentMapper studentMapper;
	public List<Student> selAllStudent(){
         return studentMapper.selAll();		
	}
}
