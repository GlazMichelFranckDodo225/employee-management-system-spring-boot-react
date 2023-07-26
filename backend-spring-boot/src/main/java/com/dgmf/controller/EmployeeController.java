package com.dgmf.controller;

import com.dgmf.dto.EmployeeDTO;
import com.dgmf.entity.Employee;
import com.dgmf.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:3000/") /* Frontend Application Url */
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody EmployeeDTO employeeDTO) {

        return employeeService.createEmployee(employeeDTO);
    }
}
