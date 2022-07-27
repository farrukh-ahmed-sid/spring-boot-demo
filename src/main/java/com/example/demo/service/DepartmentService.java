package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public void saveDepartment(DepartmentDTO departmentDTO){

        Department department = new Department();
        department.setName(departmentDTO.getName());
        departmentRepository.save(department);
    }

    public DepartmentDTO getDepartmentById(Long id){
        Department department = departmentRepository.findById(id).get();
        List<EmployeeDTO> employeeDTOs = new ArrayList<>();

        for(Employee employee : department.getEmployees()){
            EmployeeDTO employeeDTO = new EmployeeDTO(employee.getId(), employee.getName(), employee.getAge());
            employeeDTOs.add(employeeDTO);
        }

        return new DepartmentDTO(department.getId(), department.getName(), employeeDTOs);
    }

}
