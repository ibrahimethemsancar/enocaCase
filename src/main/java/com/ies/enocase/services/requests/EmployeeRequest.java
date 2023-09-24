package com.ies.enocase.services.requests;

import lombok.Data;

@Data
public class EmployeeRequest {
    private String employeeName;
    private String employeePhone;
    private Long companyId;
}
