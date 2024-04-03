package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name= "pedidos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private LocalDateTime fechaPedido;

    @Column(nullable = false)
    private Status status;

    @ManyToOne
    @JoinColumn(name = "idCustomer")
    private Cliente customer;

    @OneToMany(mappedBy = "order")
    private List<ItemPedido> orderItems;

    @OneToOne
    @JoinColumn(name = "idPayment")
    private Pago payment;

    @OneToOne
    @JoinColumn(name = "idDetail")
    private DetalleEnvio details;

    public enum Status {
        PENDIENTE,
        ENVIADO,
        ENTREGADO
    }
}
