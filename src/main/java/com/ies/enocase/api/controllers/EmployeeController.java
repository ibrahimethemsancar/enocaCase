package com.ies.enocase.api.controllers;

import com.ies.enocase.core.utilities.constants.Paths;
import com.ies.enocase.core.utilities.results.DataResult;
import com.ies.enocase.core.utilities.results.Result;
import com.ies.enocase.services.IEmployeeService;
import com.ies.enocase.services.requests.EmployeeRequest;
import com.ies.enocase.services.requests.UpdateEmployeeRequest;
import com.ies.enocase.services.responses.EmployeeResponse;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(Paths.apiPrefix + "employees")
public class EmployeeController {
    private IEmployeeService employeeService;

    public EmployeeController(IEmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<DataResult<List<EmployeeResponse>>> getAllEmployees(){
        try {
            return new ResponseEntity<>(this.employeeService.getAllEmployees(), HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
     @GetMapping("/{employeeId}")
    public ResponseEntity<DataResult<EmployeeResponse>> getEmployee(@PathVariable Long employeeId){
        try{
            return new ResponseEntity<>(this.employeeService.getEmployee(employeeId),HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
     }

    @PostMapping
    public ResponseEntity<DataResult<EmployeeResponse>> createNewEmployee(@RequestBody EmployeeRequest employeeRequest) {
        try{
            return new ResponseEntity<>(employeeService.createNewEmployee(employeeRequest), HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @PostMapping("/update")
    public ResponseEntity<Result> updateEmployee(@RequestBody @Valid UpdateEmployeeRequest request) {
        try{
            return new ResponseEntity<>(employeeService.updateEmployee(request), HttpStatus.ACCEPTED);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Result> deleteEmployee(@PathVariable Long id) {
        return ResponseEntity.ok(employeeService.deleteEmployee(id));
    }
}
