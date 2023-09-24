package com.ies.enocase.services;
import com.ies.enocase.core.utilities.results.Result;
import com.ies.enocase.services.requests.CompanyRequest;
import com.ies.enocase.services.requests.UpdateCompanyRequest;

public interface ICompanyService {
    Result getAllCompanies();
    Result  getCompany(Long companyId);
    Result createNewCompany(CompanyRequest request);
    Result updateCompany(UpdateCompanyRequest request);
    Result deleteCompany(Long companyId);
}
