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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer cantidad;
    private Double precioUnitario;

    @ManyToOne
    @JoinColumn(name = "id_pedido")

    private Pedido pedidos;

    @ManyToOne
    @JoinColumn(name = "id_product")
    private Product products;
}
