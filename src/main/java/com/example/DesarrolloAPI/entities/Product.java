package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "Product")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private Double price;
    private Integer stock;
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ItemPedido> itemPedido;

}
