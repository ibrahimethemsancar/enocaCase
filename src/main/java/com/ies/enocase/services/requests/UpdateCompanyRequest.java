package com.ies.enocase.services.requests;

import com.ies.enocase.entities.concretes.Employee;
import lombok.Data;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Data
public class UpdateCompanyRequest {
    @NonNull
    private long id;
    @NonNull
    private String companyName;
    @NonNull
    private Long employeeNumber;
    private List<Employee> employeeList = new ArrayList<>();
}
