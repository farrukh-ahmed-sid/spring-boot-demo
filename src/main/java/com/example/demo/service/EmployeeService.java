package com.example.demo.service;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.DepartmentRepository;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repository;

    @Autowired
    DepartmentRepository departmentRepository;

    public List<EmployeeDTO> getEmployees() {
        List<Employee> employees = repository.findAll();
        List<EmployeeDTO> employeeDTOList = new ArrayList<>();

        for (Employee employee : employees) {

            Department department = employee.getDepartment();

            DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(), department.getName());

            EmployeeDTO dto = new EmployeeDTO(employee.getId(),
                    employee.getName(),
                    employee.getAge(),
                    departmentDTO);

            employeeDTOList.add(dto);
        }

        return employeeDTOList;
    }

    public EmployeeDTO getName(Long id) {
        Employee employee = repository.getById(id);
        Department department = employee.getDepartment();

        DepartmentDTO departmentDTO = new DepartmentDTO(department.getId(), department.getName());

        return new EmployeeDTO(employee.getId(), employee.getName(),
                employee.getAge(), departmentDTO);
    }

    public void saveEmployee(EmployeeDTO employeeDTO) {

        Employee employee = new Employee();
        employee.setName(employeeDTO.getName());
        employee.setAge(employeeDTO.getAge());

        Department department = departmentRepository.findById(employeeDTO.getDepartmentDTO().getId()).get();

        employee.setDepartment(department);
        repository.save(employee);
    }
}
