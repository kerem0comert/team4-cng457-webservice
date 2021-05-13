package com.cng457.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Computer extends Product{
    private String screenResolution;
    private String processor;
    private int memory;
    private int storageCapacity;
}
