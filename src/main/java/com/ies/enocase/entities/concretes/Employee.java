package com.ies.enocase.entities.concretes;

import com.ies.enocase.entities.abstracts.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "employee")
@Entity
public class Employee  extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "employee_id")
    private long id;

    @NonNull
    @Column(name = "employee_name")
    private String employeeName;

    @NonNull
    @NotEmpty(message = "Employee phone field can not be empty!")
    @Size(min = 10, max = 11)
    @Column(name = "employee_phone")
    private String employeePhone;


    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(name = "is_actv")
    private int isActv;
}
