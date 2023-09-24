package com.ies.enocase.services;

import com.ies.enocase.core.utilities.constants.Messages;
import com.ies.enocase.core.utilities.mapper.EmployeeResponseConverter;
import com.ies.enocase.core.utilities.results.DataResult;
import com.ies.enocase.core.utilities.results.ErrorResult;
import com.ies.enocase.core.utilities.results.Result;
import com.ies.enocase.core.utilities.results.SuccessResult;
import com.ies.enocase.entities.concretes.Company;
import com.ies.enocase.entities.concretes.Employee;
import com.ies.enocase.repositories.ICompanyRepository;
import com.ies.enocase.repositories.IEmployeeRepository;
import com.ies.enocase.services.requests.EmployeeRequest;
import com.ies.enocase.services.requests.UpdateEmployeeRequest;
import com.ies.enocase.services.responses.EmployeeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Service
public class EmployeeServiceImpl implements  IEmployeeService{
    private IEmployeeRepository employeeRepository;
    private ICompanyRepository companyRepository;
    @Autowired
    private EmployeeResponseConverter employeeResponseConverter;
    public EmployeeServiceImpl(IEmployeeRepository employeeRepository, ICompanyRepository companyRepository){
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }
    @Override
    public DataResult<EmployeeResponse> getEmployee(Long employeeId) {
        if(employeeId != null){
            Optional<Employee> optionalEmployee = this.employeeRepository.findById(employeeId);
            if(optionalEmployee.isPresent()){
                EmployeeResponse response =
                        this.employeeResponseConverter.mapEmployeetoEmloyeeResponse(optionalEmployee.get());
                return new DataResult<>(response,true);
            }

        }
        return null;
    }

    @Override
    public DataResult<EmployeeResponse> createNewEmployee(EmployeeRequest request) {
        Optional<Company> optCompany = this.companyRepository.findById(request.getCompanyId());
        if(optCompany.isPresent()){
            Employee employee = this.employeeResponseConverter.mapEmployeeRequestToEmployee(request, optCompany.get());
            Employee savedEmployee = this.employeeRepository.save(employee);
            return new DataResult<>(this.employeeResponseConverter.mapEmployeetoEmloyeeResponse(savedEmployee),true);
        }
        throw  new RuntimeException(Messages.Company.companyNotFound);
    }

    @Override
    public Result updateEmployee(UpdateEmployeeRequest request) {
        Optional<Employee> optionalEmployee = this.employeeRepository.findById(request.getId());
        if(!optionalEmployee.isPresent()){
            throw new RuntimeException(Messages.Employee.employeeNotFound);
        }
        Optional<Company> optCompany = this.companyRepository.findById(request.getCompanyId());
        if(optCompany.isPresent()){
            Employee employee = this.employeeRepository.findById(request.getId()).get();
            employee.setEmployeeName(employee.getEmployeeName().equals(request.getEmployeeName()) ? employee.getEmployeeName()
                    : request.getEmployeeName() );
            employee.setEmployeePhone(employee.getEmployeePhone().equals(request.getEmployeePhone()) ? employee.getEmployeePhone()
                    : request.getEmployeePhone());
            employee.setCompany(employee.getCompany().equals(optCompany.get()) ? employee.getCompany()
                    : optCompany.get());
            employee.setUDate(LocalDateTime.now());
            Employee updateEmployee = this.employeeRepository.save(employee);
            EmployeeResponse response = this.employeeResponseConverter.mapEmployeetoEmloyeeResponse(updateEmployee);
            return new DataResult<>(response,true);
        }
        return new ErrorResult(Messages.Company.companyNotFound);
    }

    @Override
    public Result deleteEmployee(Long employeeId) {
        Optional<Employee> optEmployee = this.employeeRepository.findById(employeeId);
        if(optEmployee.isPresent()){
            this.employeeRepository.delete(optEmployee.get());
            return  new SuccessResult(Messages.Employee.employeeIsDeleted);
        }
        return new ErrorResult(Messages.Employee.employeeNotFound);
    }

    @Override
    public DataResult<List<EmployeeResponse>> getAllEmployees() {
        List<Employee> employeeList = this.employeeRepository.findAll();

        List<EmployeeResponse> employeeResponseList = new ArrayList<>();
        employeeList.stream().forEach(employee -> {
            EmployeeResponse employeeResponse =
                    this.employeeResponseConverter.mapEmployeetoEmloyeeResponse(employee);
            employeeResponseList.add(employeeResponse);
        });

        return new DataResult<>(employeeResponseList,true);
    }
}
