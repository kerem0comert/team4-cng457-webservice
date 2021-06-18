package com.cng457.Project.entity;

import com.fasterxml.jackson.annotation.*;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "productId", scope = Product.class)
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY, property = "type") @JsonSubTypes({

        @JsonSubTypes.Type(value = Computer.class, name = "computer"),
        @JsonSubTypes.Type(value = Phone.class, name = "phone")
})
public abstract class Product {
    @Id private int productId;
    private String model;
    private String batteryLife;
    private String screenSize;
    private int price;

    @OneToMany(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Review> reviewList = new ArrayList<>();

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "ProductExtraFeatures",
            joinColumns = @JoinColumn (name = "productId", updatable=false,insertable=false, nullable = false),
            inverseJoinColumns = @JoinColumn (name = "efId", updatable=false,insertable=false, nullable = false))
    private List<ExtraFeatures> extraFeaturesList;

    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name="brandId") This is not necessary and causes some inconsistency
    private Brand brand;
}
