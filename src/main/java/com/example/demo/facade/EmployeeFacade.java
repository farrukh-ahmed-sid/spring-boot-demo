package com.example.demo.facade;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeFacade {

    @Autowired
    EmployeeService employeeService;

    public List<EmployeeDTO> getEmployees() {
        return employeeService.getEmployees();
    }

    public EmployeeDTO getEmployeeById(Long id) {
        return employeeService.getEmployeeById(id);
    }

    public void saveEmployee(EmployeeDTO employeeDTO) {
        employeeService.saveEmployee(employeeDTO);
    }
}
