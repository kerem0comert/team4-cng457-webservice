package com.cng457.Project.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExtraFeatures {
    @Id
    private int efId;
    private String description;
    private String featureName;

    @JsonBackReference
    @ManyToMany(mappedBy = "extraFeaturesList", fetch = FetchType.LAZY)
    private List<Product> productList;

}
