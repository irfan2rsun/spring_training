package com.cydeo.entity;

import javax.persistence.Entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

public class Genre extends BaseEntity {

    private String name;
}
