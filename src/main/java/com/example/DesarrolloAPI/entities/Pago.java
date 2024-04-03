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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "pago_total")
    private Double totalPago;
    @Column(name = "fecha_pago")
    private LocalDateTime fechaPago;
    @Column(name = "metodo_pago")
    private MetodoPago metodoPago;

    @OneToOne(mappedBy = "payment")
    private Pedido order;

    public enum MetodoPago {
            EFECTIVO,
            TARJETA_CREDITO,
            PAYPAL,
            NEQUI,
            DAVIPLATA,
            PSE
    }
}

