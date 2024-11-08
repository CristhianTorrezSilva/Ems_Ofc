package com.pa.ems_offc.mapper;

import com.pa.ems_offc.dto.DepartmentDto;
import com.pa.ems_offc.model.Department;

public class DepartmentMapper {

    //Convertir la Entidad JPA Department en un Department DTO
    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription()
        );
    }

    //Convertir el Department DTO en una Entidad JPA Department
    public static Department mapToDepartment(DepartmentDto departmentDto) {

        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setDepartmentName(departmentDto.getDepartmentName());
        department.setDepartmentDescription(departmentDto.getDepartmentDescription());
        return department;
    }

}
