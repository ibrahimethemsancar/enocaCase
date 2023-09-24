package com.ies.enocase.api.controllers;

import com.ies.enocase.core.utilities.constants.Paths;

import com.ies.enocase.core.utilities.results.Result;
import com.ies.enocase.services.ICompanyService;
import com.ies.enocase.services.requests.CompanyRequest;
import com.ies.enocase.services.requests.UpdateCompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(Paths.apiPrefix + "company")
public class CompanyController {
    @Autowired
    private ICompanyService companyService;

    @GetMapping
    public ResponseEntity<Result> getAllEmployees(){
        try {
            return new ResponseEntity<>(this.companyService.getAllCompanies(), HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @GetMapping("/{companyId}")
    public ResponseEntity<Result> getCompany(@PathVariable Long companyId){
        try{
            return new ResponseEntity<>(this.companyService.getCompany(companyId),HttpStatus.OK);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<Result> createNewCompany(@RequestBody CompanyRequest companyRequest) {
        try{
            return new ResponseEntity<>(companyService.createNewCompany(companyRequest), HttpStatus.CREATED);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @PostMapping("/update")
    public ResponseEntity<Result> updateCompany(@RequestBody UpdateCompanyRequest request) {
        try{
            return new ResponseEntity<>(this.companyService.updateCompany(request), HttpStatus.ACCEPTED);
        }catch (Exception e){
            throw new RuntimeException(e.getMessage());
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Result> deleteCompany(@PathVariable Long id) {
        return ResponseEntity.ok(this.companyService.deleteCompany(id));
    }

}
