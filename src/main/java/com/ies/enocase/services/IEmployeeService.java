package com.ies.enocase.services;

import com.ies.enocase.core.utilities.results.DataResult;
import com.ies.enocase.core.utilities.results.Result;
import com.ies.enocase.services.requests.EmployeeRequest;
import com.ies.enocase.services.requests.UpdateEmployeeRequest;
import com.ies.enocase.services.responses.EmployeeResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface IEmployeeService {
    DataResult<List<EmployeeResponse>> getAllEmployees();
    DataResult<EmployeeResponse> getEmployee(Long employeeId);
    DataResult<EmployeeResponse> createNewEmployee(EmployeeRequest request);
    Result updateEmployee(UpdateEmployeeRequest request);
    Result deleteEmployee(Long employeeId);

}
