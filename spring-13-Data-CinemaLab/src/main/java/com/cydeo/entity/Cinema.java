package com.cydeo.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cinema extends BaseEntity {

    private String name;
    private String sponsoredName;

    @ManyToOne(fetch = FetchType.LAZY) //@ManyToOne Fetching type is Eager that's why I changed it to LAZY
    private Location location;

    @Override
    public String toString() {
        return "Cinema{" +
                "name='" + name + '\'' +
                ", sponsoredName='" + sponsoredName + '\'' +
                '}';
    }
}
