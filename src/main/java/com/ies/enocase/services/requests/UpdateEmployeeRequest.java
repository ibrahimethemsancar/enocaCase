package com.ies.enocase.services.requests;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.NonNull;

@Data
public class UpdateEmployeeRequest {
    private long id;
    @NonNull

    private String employeeName;
    @NonNull

    private String employeePhone;
    @NonNull

    private Long companyId;
}
