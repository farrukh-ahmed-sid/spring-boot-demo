package com.example.demo.facade;

import com.example.demo.dto.DepartmentDTO;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DepartmentFacade {

    @Autowired
    private DepartmentService departmentService;

    public DepartmentDTO getDepartmentById(Long id){
        return departmentService.getDepartmentById(id);
    }

    public void saveDepartment(DepartmentDTO departmentDTO){
        departmentService.saveDepartment(departmentDTO);
    }
}
