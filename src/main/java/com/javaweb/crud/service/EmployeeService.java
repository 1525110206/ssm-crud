package com.javaweb.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaweb.crud.bean.Employee;
import com.javaweb.crud.bean.EmployeeExample;
import com.javaweb.crud.bean.EmployeeExample.Criteria;
import com.javaweb.crud.bean.Msg;
import com.javaweb.crud.dao.EmployeeMapper;

@Service
public class EmployeeService {
	@Autowired
	EmployeeMapper employeeMapper;
	
	public List<Employee> getAll() {
		
		return employeeMapper.selectByExampleWithDept(null);
	}

	public Msg saveEmp(Employee employee) {
		employeeMapper.insertSelective(employee);
		return Msg.success();
	}
	//检验用户名是否可用
	public boolean checkUser(String empName) {
		System.out.println("222");
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpNameEqualTo(empName);
		long count = employeeMapper.countByExample(example);
		System.out.println(count);
		return count == 0;
	}
	//按照员工id查询员工
	public Employee getEmp(Integer id) {
		// TODO Auto-generated method stub
		Employee employee = employeeMapper.selectByPrimaryKey(id);
		return employee;
	}

	public void updateEmp(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.updateByPrimaryKeySelective(employee);
	}

	public void deleteEmp(Integer id) {
		
		employeeMapper.deleteByPrimaryKey(id);
	}

	public void deleteBatch(List<Integer> ids) {
		
		EmployeeExample example = new EmployeeExample();
		Criteria criteria = example.createCriteria();
		criteria.andEmpIdIn(ids);
		employeeMapper.deleteByExample(example);
	}


}
