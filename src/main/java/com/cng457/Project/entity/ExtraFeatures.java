package com.cng457.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExtraFeatures {
    @Id private int efId;
    private String description;
    private String featureName;

    @ManyToMany (fetch = FetchType.EAGER)
    @JoinTable (name = "ProductExtraFeatures",
            joinColumns = @JoinColumn (name = "efId"),
            inverseJoinColumns = @JoinColumn (name = "productId"))
    private List<Product> productList;

}
