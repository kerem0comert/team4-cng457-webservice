package com.cng457.Project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Review {
    @Id private int reviewId;
    private int rating;
    private String comment;

    @ManyToOne(fetch = FetchType.LAZY)
    private Product product;
}
