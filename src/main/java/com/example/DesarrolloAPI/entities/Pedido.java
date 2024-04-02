package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name= "Pedido")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private LocalDateTime fechaPedido;
    private String status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @OneToMany(mappedBy = "Pedido", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<ItemPedido> itemPedido;


}
