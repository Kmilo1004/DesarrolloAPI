package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "ItemPedido")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Integer cantidad;
    private Double precioUnitario;
    @ManyToOne
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
