package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name= "Pago")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private Double totalPago;
    private LocalDateTime fechaPago;
    private MetodoPago metodoPago;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

    public enum MetodoPago {
            EFECTIVO,
            TARJETA_CREDITO,
            PAYPAL,
            NEQUI,
            DAVIPLATA,
            PSE
    }
}

