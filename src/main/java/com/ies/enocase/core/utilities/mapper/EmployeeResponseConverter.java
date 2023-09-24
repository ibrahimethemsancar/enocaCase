package com.ies.enocase.core.utilities.mapper;

import com.ies.enocase.entities.concretes.Company;
import com.ies.enocase.entities.concretes.Employee;
import com.ies.enocase.services.requests.EmployeeRequest;
import com.ies.enocase.services.requests.UpdateEmployeeRequest;
import com.ies.enocase.services.responses.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class EmployeeResponseConverter {
    @Autowired
    private ModelMapper modelMapper;
    public EmployeeResponse mapEmployeetoEmloyeeResponse(Employee employee){
        EmployeeResponse response = modelMapper.map(employee, EmployeeResponse.class);
        return response;
    }

    public Employee mapEmployeeRequestToEmployee(EmployeeRequest employeeRequest, Company company){
        Employee response = modelMapper.map(employeeRequest, Employee.class);
        response.setId(0);
        response.setCompany(company);
        response.setCDate(LocalDateTime.now());
        return response;
    }
}
