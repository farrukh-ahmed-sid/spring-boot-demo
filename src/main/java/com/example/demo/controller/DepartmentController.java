package com.example.demo.controller;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.facade.DepartmentFacade;
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
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentFacade departmentFacade;

    @GetMapping("/{id}")
    public DepartmentDTO getDepartmentById(@PathVariable("id") Long id){
        return departmentFacade.getDepartmentById(id);
    }

    @GetMapping("/")
    public List<DepartmentDTO> getDepartments(){
        return departmentFacade.getDepartments();
    }

    @PostMapping("/")
    public ResponseEntity<String> saveDepartment(@RequestBody DepartmentDTO departmentDTO){
        departmentFacade.saveDepartment(departmentDTO);
        return ResponseEntity.ok().body(HttpStatus.CREATED.name());
    }

}
