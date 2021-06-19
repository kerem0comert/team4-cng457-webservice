package com.cng457.Project.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "efId", scope = ExtraFeatures.class)
public class ExtraFeatures {
    @Id private int efId;
    private String description;
    private String featureName;

    @ManyToMany (mappedBy = "extraFeaturesList", fetch = FetchType.LAZY)
    private List<Product> productList;

}
