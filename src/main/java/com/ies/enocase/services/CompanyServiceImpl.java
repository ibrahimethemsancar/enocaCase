package com.ies.enocase.services;

import com.ies.enocase.core.utilities.constants.Messages;
import com.ies.enocase.core.utilities.mapper.CompanyConverter;
import com.ies.enocase.core.utilities.mapper.EmployeeResponseConverter;
import com.ies.enocase.core.utilities.results.DataResult;
import com.ies.enocase.core.utilities.results.ErrorResult;
import com.ies.enocase.core.utilities.results.Result;
import com.ies.enocase.core.utilities.results.SuccessResult;
import com.ies.enocase.entities.concretes.Company;
import com.ies.enocase.entities.concretes.Employee;
import com.ies.enocase.repositories.ICompanyRepository;
import com.ies.enocase.repositories.IEmployeeRepository;
import com.ies.enocase.services.requests.CompanyRequest;
import com.ies.enocase.services.requests.UpdateCompanyRequest;
import com.ies.enocase.services.responses.CompanyResponse;
import com.ies.enocase.services.responses.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements ICompanyService{
    @Autowired
    private ICompanyRepository companyRepository;
    @Autowired
    private CompanyConverter companyConverter;
    @Override
    public Result getAllCompanies() {
        List<Company> employeeList = this.companyRepository.findAll();

        List<CompanyResponse> companyResponseList = new ArrayList<>();
        employeeList.stream().forEach(company -> {
            CompanyResponse companyResponse =
                    this.companyConverter.mapCompanytoCompanyResponse(company);
            companyResponseList.add(companyResponse);
        });

        return new DataResult<>(companyResponseList,true);
    }

    @Override
    public Result getCompany(Long companyId) {
        if(companyId != null){
            Optional<Company> optionalCompany = this.companyRepository.findById(companyId);
            if(optionalCompany.isPresent()){
                CompanyResponse response =
                        this.companyConverter.mapCompanytoCompanyResponse(optionalCompany.get());
                return new DataResult<>(response,true);
            }

        }
        return null;
    }

    @Override
    public Result createNewCompany(CompanyRequest request) {
        Company company = new Company();
        company.setCompanyName(request.getCompanyName());
        company.setCDate(LocalDateTime.now());
        company.setEmployeeNumber(request.getEmployeeNumber());
        Company savedCompany = this.companyRepository.save(company);

        return new DataResult<>(this.companyConverter.mapCompanytoCompanyResponse(savedCompany), true);

    }

    @Override
    public Result updateCompany(UpdateCompanyRequest request) {
        Optional<Company> optionalCompany = this.companyRepository.findById(request.getId());
        if(!optionalCompany.isPresent()){
            throw new RuntimeException(Messages.Company.companyNotFound);
        }

        Company company = this.companyRepository.findById(request.getId()).get();
        company.setCompanyName(company.getCompanyName().equals(request.getCompanyName()) ? company.getCompanyName()
                    : request.getCompanyName());
        company.setEmployeeNumber(company.getEmployeeNumber() == request.getEmployeeNumber() ? company.getEmployeeNumber()
                    : request.getEmployeeNumber());
        company.setEmployeeList(company.getEmployeeList().equals(request.getEmployeeList()) ? company.getEmployeeList()
                    : request.getEmployeeList());
            company.setUDate(LocalDateTime.now());
        Company updateCompany = this.companyRepository.save(company);
        CompanyResponse response = this.companyConverter.mapCompanytoCompanyResponse(updateCompany);
            return new DataResult<>(response,true);
    }

    @Override
    public Result deleteCompany(Long companyId) {
        Optional<Company> optCompany = this.companyRepository.findById(companyId);
        if(optCompany.isPresent()){
            this.companyRepository.delete(optCompany.get());
            return  new SuccessResult(Messages.Company.companyIsDeleted);
        }
        return new ErrorResult(Messages.Company.companyNotFound);
    }
}
