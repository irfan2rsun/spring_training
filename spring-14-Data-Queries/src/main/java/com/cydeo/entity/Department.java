package com.cydeo.entity;


import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@Data
@Table(name = "departments")
public class Department {

    @Id
    private String department;
    private String division;
}
