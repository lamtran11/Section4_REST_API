package com.example.springCrudDemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.springCrudDemo.dao.EmployeeDAO;
import com.example.springCrudDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

	@Override
	public Employee findById(int theId) {
		// TODO 自動生成されたメソッド・スタブ
		
		return employeeDAO.findById(theId);
	}

	@Transactional
	@Override
	public Employee save(Employee theEmployee) {
		// TODO 自動生成されたメソッド・スタブ
		return employeeDAO.save(theEmployee);
	}

	@Transactional
	@Override
	public void deleteById(int theId) {
		// TODO 自動生成されたメソッド・スタブ
		employeeDAO.deleteById(theId);
	}
}




































