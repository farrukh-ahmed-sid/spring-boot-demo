package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmployeeDTO {

    private Long id;
    private String name;

    private Integer age;

    private DepartmentDTO departmentDTO;

    public EmployeeDTO(){}

    public EmployeeDTO(Long id, String name, Integer age, DepartmentDTO departmentDTO) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.departmentDTO = departmentDTO;
    }

    public EmployeeDTO(Long id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public DepartmentDTO getDepartmentDTO() {
        return departmentDTO;
    }

    public void setDepartmentDTO(DepartmentDTO departmentDTO) {
        this.departmentDTO = departmentDTO;
    }
}

