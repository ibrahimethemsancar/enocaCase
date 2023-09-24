package com.ies.enocase.repositories;

import com.ies.enocase.entities.concretes.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmployeeRepository extends JpaRepository<Employee,Long> {

}
