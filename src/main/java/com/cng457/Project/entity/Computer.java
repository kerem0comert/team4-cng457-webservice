package com.cng457.Project.entity;

import com.fasterxml.jackson.annotation.JsonTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonTypeName("computer")
public class Computer extends Product {
    private String screenResolution;
    private String processor;
    private int memory;
    private int storageCapacity;
}
