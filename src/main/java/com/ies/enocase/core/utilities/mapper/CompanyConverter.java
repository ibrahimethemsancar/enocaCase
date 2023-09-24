package com.ies.enocase.core.utilities.mapper;

import com.ies.enocase.entities.concretes.Company;
import com.ies.enocase.entities.concretes.Employee;
import com.ies.enocase.services.responses.CompanyResponse;
import com.ies.enocase.services.responses.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CompanyConverter {
    @Autowired
    private ModelMapper modelMapper;
    public CompanyResponse mapCompanytoCompanyResponse(Company company){
        CompanyResponse response = modelMapper.map(company, CompanyResponse.class);
        return response;
    }

}
