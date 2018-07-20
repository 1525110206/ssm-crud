package com.javaweb.crud.test;

import java.util.UUID;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.javaweb.crud.bean.Department;
import com.javaweb.crud.bean.Employee;
import com.javaweb.crud.dao.DepartmentMapper;
import com.javaweb.crud.dao.EmployeeMapper;


@RunWith(SpringJUnit4ClassRunner.class)//spring�ṩ�ĵ�Ԫ����ģ��
@ContextConfiguration(locations={"classpath:applicationContext.xml"})
public class MapperTest {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;
	@Autowired
	SqlSession sqlSession;
	/*
	 * ����DepartmentMapper
	 */
	@Test
	public void testCRUD(){
		System.out.println(departmentMapper);
		//���뼸������
		/*departmentMapper.insertSelective(new Department(null, "������"));
		departmentMapper.insertSelective(new Department(null, "���Բ�"));
*/		
//		employeeMapper.insertSelective(new Employee(null, "jerry", "M", "jerry@qq.com", 1));
		
		EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
		
		for(int i = 0; i < 1000; i++){
			String uid = UUID.randomUUID().toString().substring(0,5);
			mapper.insertSelective(new Employee(null, uid, "M", uid+"@qq.com", 1));
		}
		System.out.println("���");
	}
	
}
