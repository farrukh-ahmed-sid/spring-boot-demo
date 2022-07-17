package com.example.demo.controller;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.facade.EmployeeFacade;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/test")
public class EmployeeController {

    @Autowired
    EmployeeFacade employeeFacade;

    @GetMapping
    public List<EmployeeDTO> getEmployees(){
        return employeeFacade.getEmployees();
    }

    @GetMapping("/{id}")
    //@RequestMapping(method = RequestMethod.GET, path = "/")
    public String getTest(@PathVariable("id") Integer id){

        Employee employee = employeeFacade.getName(id);
        return employee.getName();
    }

    @PostMapping("/")
    public void saveTest(@RequestBody EmployeeDTO employeeDTO){
        employeeFacade.saveEmployee(employeeDTO);
    }

    //add APIs for update and delete data in db
}
