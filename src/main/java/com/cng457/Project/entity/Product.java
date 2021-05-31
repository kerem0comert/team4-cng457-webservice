package com.cng457.Project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId")
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

    @ManyToMany (mappedBy = "productList")
    private List<ExtraFeatures> extraFeaturesList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="brandId")
    private Brand brand;
}
