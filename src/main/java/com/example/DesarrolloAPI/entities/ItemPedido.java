package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "itemPedidos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class ItemPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer cantidad;
    @Column(nullable = false)
    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "idOrder")
    private Pedido order;

    @ManyToOne
    @JoinColumn(name = "idProduct")
    private Product product;
}
