package com.example.ed.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String name;
    private String productDescription;
    private Double totalQuantity;
    private Double costOfProduction;
    private Double proposedRetailPrice;
    @OneToMany
    private List<Details> content;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", totalQuantity=" + totalQuantity +
                ", costOfProduction=" + costOfProduction +
                ", proposedRetailPrice=" + proposedRetailPrice +
                '}';
    }
}
