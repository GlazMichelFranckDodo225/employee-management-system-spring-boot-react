package com.dgmf.service;

import com.dgmf.dto.EmployeeDTO;
import com.dgmf.entity.Employee;

public interface EmployeeService {
    Employee createEmployee(EmployeeDTO employeeDTO);
}
