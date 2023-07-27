package com.dgmf.service;

import com.dgmf.dto.EmployeeDTO;
import com.dgmf.entity.Employee;

import java.util.List;

public interface EmployeeService {
    // Creation d'Employee à partir d'EmployeeDTO
    Employee createEmployee(EmployeeDTO employeeDTO);
    // Récupération d'EmployeeDTOs à partir d'Employees de la DB
    List<EmployeeDTO> getAllEmployees();
}
