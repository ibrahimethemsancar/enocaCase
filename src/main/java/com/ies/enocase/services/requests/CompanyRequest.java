package com.ies.enocase.services.requests;

import lombok.Data;
import lombok.NonNull;

@Data
public class CompanyRequest {
    @NonNull
    private String companyName;
    @NonNull
    private Long employeeNumber;
}
