package com.dgmf.service.impl;

import com.dgmf.dto.EmployeeDTO;
import com.dgmf.entity.Employee;
import com.dgmf.repository.EmployeeRepository;
import com.dgmf.service.EmployeeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee createEmployee(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeDTO, employee);

        employeeRepository.save(employee);

        return employee;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        // Recupération de tous les "Employee" de la DB
        List<Employee> employees = employeeRepository.findAll();
        // Conversion de la liste d'Employee en une liste d'EmployeeDTO
        List<EmployeeDTO> employeeDTOS = employees.stream()
                .map(employee -> new EmployeeDTO(
                        employee.getId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getEmailId()))
                .collect(Collectors.toList());

        return employeeDTOS;
    }
}
