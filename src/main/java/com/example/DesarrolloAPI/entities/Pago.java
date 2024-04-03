package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.nio.MappedByteBuffer;
import java.time.LocalDateTime;

@Entity
@Table(name= "pagos")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double totalPago;
    private LocalDateTime fechaPago;
    private MetodoPago metodoPago;

    @OneToOne(mappedBy = "pago")
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

