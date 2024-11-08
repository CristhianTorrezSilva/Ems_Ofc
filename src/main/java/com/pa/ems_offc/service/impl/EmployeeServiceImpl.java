package com.pa.ems_offc.service.impl;

import com.pa.ems_offc.dto.EmployeeDto;
import com.pa.ems_offc.exception.ResourceNotFoundException;
import com.pa.ems_offc.mapper.EmployeeMapper;
import com.pa.ems_offc.model.Department;
import com.pa.ems_offc.model.Employee;
import com.pa.ems_offc.model.Hobby;
import com.pa.ems_offc.model.Vehicle;
import com.pa.ems_offc.repository.DepartmentRepository;
import com.pa.ems_offc.repository.EmployeeRepository;
import com.pa.ems_offc.repository.HobbyRepository;
import com.pa.ems_offc.repository.VehicleRepository;
import com.pa.ems_offc.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final VehicleRepository vehicleRepository;
    private EmployeeRepository employeeRepository;

    private DepartmentRepository departmentRepository;

    private HobbyRepository hobbyRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) {

        Employee employee = EmployeeMapper.mapToEmployee(employeeDto);

        Department department = departmentRepository.findById(employeeDto.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department is not exists with id: " + employeeDto.getDepartmentId()));

        employee.setDepartment(department);
        Hobby hobby = hobbyRepository.findById(employeeDto.getHobbyId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hobby is not exists with id: " + employeeDto.getHobbyId()));

        employee.setHobby(hobby);

        Vehicle vehicle = vehicleRepository.findById(employeeDto.getVehicleId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle is not exists with id: " + employeeDto.getVehicleId()));

        employee.setVehicle(vehicle);

        Employee savedEmployee = employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Employee is not exists with given id : " + employeeId));

        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map((employee) -> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Department department = departmentRepository.findById(updatedEmployee.getDepartmentId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Department is not exists with id: " + updatedEmployee.getDepartmentId()));

        employee.setDepartment(department);

        Hobby hobby = hobbyRepository.findById(updatedEmployee.getHobbyId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Hobby is not exists with id: " + updatedEmployee.getHobbyId()));

        employee.setHobby(hobby);

        Vehicle vehicle = vehicleRepository.findById(updatedEmployee.getVehicleId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Vehicle is not exists with id: " + updatedEmployee.getVehicleId()));

        employee.setVehicle(vehicle);

        Employee updatedEmployeeObj = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeObj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee is not exists with given id: " + employeeId)
        );

        employeeRepository.deleteById(employeeId);
    }
}
