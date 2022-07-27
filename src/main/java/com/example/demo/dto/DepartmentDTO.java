package com.example.demo.dto;

import java.util.List;

public class DepartmentDTO {

    private Long id;
    private String name;

    private List<EmployeeDTO> employeeDTOs;

    public DepartmentDTO(){}

    public DepartmentDTO(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public DepartmentDTO(Long id, String name, List<EmployeeDTO> employeeDTOs) {
        this.id = id;
        this.name = name;
        this.employeeDTOs = employeeDTOs;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<EmployeeDTO> getEmployeeDTOs() {
        return employeeDTOs;
    }

    public void setEmployeeDTOs(List<EmployeeDTO> employeeDTOs) {
        this.employeeDTOs = employeeDTOs;
    }
}
