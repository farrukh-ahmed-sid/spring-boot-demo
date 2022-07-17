package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = repository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee e : employees) {
            EmployeeDTO dto = new EmployeeDTO();
            dto.setId(e.getId());
            dto.setName(e.getName());
            employeeDTOList.add(dto);
        }

        return employeeDTOList;
    }

    public Employee getName(Integer id) {

        return repository.getById(id);
    }

    public void saveEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());
        repository.save(employee);
    }
}
