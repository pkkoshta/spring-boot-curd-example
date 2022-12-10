package com.prashant.service;

import com.prashant.dao.EmployeeRepository;
import com.prashant.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(int eid){
        employeeRepository.deleteById(eid);
    }

    public Employee updateEmployee(int eid, Employee employee){

        Optional<Employee> exitingEmployee = employeeRepository.findById(eid);
        if (exitingEmployee.isPresent()){
            Employee employee1 = exitingEmployee.get();
            employee1.setName(employee.getName());
            employee1.setLastname(employee.getLastname());
            employee1.setAge(employee.getAge());
            employee1.setSalary(employee.getSalary());
            return employeeRepository.save(employee1);


        }
return null;

    }

}
