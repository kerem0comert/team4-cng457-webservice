package com.cng457.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ExtraFeatures {
    @Id private int efId;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
