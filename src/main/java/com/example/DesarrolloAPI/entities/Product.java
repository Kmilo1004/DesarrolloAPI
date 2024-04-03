package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "products")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double price;
    private Integer stock;

    @OneToMany(mappedBy = "product")
    private List<ItemPedido> itemPedidos;

}
