package com.ies.enocase.entities.concretes;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ies.enocase.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
@Entity
public class Company extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "company_id")
    private long companyId;

    @NonNull
    @Column(name = "company_name")
    private String companyName;

    @NonNull
    @Column(name = "employee_number")
    private Long employeeNumber;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "company", fetch =FetchType.EAGER)
    private List<Employee> employeeList;

    @Column(name = "is_actv")
    private int isActv;
}
