package com.example.springCrudDemo.service;

import com.example.springCrudDemo.dao.EmployeeRepository;
import com.example.springCrudDemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

	@Override
	public Employee findById(int theId) {
		// TODO 自動生成されたメソッド・スタブ
		Optional<Employee> result = employeeRepository.findById(theId);

		Employee theEmployee = null;

		 if (result.isPresent()) {
             theEmployee = result.get();
        } else {
			 throw new RuntimeException("Employee not found with id: " + theId);
		 }
		return theEmployee;
	}

	// No need for write @Transactional here because JpaRepository already have it
	@Override
	public Employee save(Employee theEmployee) {
		// TODO 自動生成されたメソッド・スタブ
		return employeeRepository.save(theEmployee);
	}

	@Override
	public void deleteById(int theId) {
		// TODO 自動生成されたメソッド・スタブ
		employeeRepository.deleteById(theId);
	}
}




































