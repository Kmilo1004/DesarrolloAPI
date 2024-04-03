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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime fechaPedido;
    private Status status;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private Cliente clientes;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itemPedidos;

    @OneToOne
    @JoinColumn(name = "id_pago")
    private Pago pago;

    @OneToOne
    @JoinColumn(name = "id_pedido")
    private DetalleEnvio detalleEnvio;

    public enum Status {
        PENDIENTE,
        ENVIADO,
        ENTREGADO
    }
}
