package com.ies.enocase.entities.abstracts;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "CDATE")
    private LocalDateTime cDate;

    @Column(name = "CUSER")
    private Long cUser;

    @Column(name = "UDATE")
    private LocalDateTime uDate;

    @Column(name = "UUSER")
    private Long uUser;
}
