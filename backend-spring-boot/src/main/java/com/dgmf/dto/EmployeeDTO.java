package com.dgmf.dto;

import com.dgmf.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class EmployeeDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String emailId;
}
