package com.example.demo.controller;


import com.example.demo.dto.EmployeeDTO;
import com.example.demo.facade.EmployeeFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeFacade employeeFacade;

    @GetMapping
    public List<EmployeeDTO> getEmployees() {
        return employeeFacade.getEmployees();
    }

    @GetMapping("/{id}")
    //@RequestMapping(method = RequestMethod.GET, path = "/")
    public EmployeeDTO getTest(@PathVariable("id") Long id) {

        return employeeFacade.getName(id);
    }

    @PostMapping("/")
    public ResponseEntity<String> saveTest(@RequestBody EmployeeDTO employeeDTO) {
        employeeFacade.saveEmployee(employeeDTO);
        return ResponseEntity.ok().body(HttpStatus.CREATED.name());
    }

    //add APIs for update and delete data in db
    //try with @RequestParam where value come with query param of url
}
