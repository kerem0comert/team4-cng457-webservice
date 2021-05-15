package com.cng457.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Product {
    @Id private int productId;
    private String model;
    private String batteryLife;
    private String screenSize;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Review> reviewList = new ArrayList<>();

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<ExtraFeatures> extraFeaturesList = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Brand brand;
}
