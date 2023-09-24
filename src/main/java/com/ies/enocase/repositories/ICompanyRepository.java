package com.ies.enocase.repositories;

import com.ies.enocase.entities.concretes.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company,Long> {
}
