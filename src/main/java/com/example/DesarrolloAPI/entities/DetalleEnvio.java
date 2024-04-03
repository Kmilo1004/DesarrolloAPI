package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "detalleEnvios")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DetalleEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String transportadora;

    @Column(nullable = false)
    private String numeroGuia;

    @OneToOne(mappedBy = "details")
    private Pedido order;
}
