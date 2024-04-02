package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name= "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class DetalleEnvio {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String direccion;
    private String transportadora;
    private String numeroGuia;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pedido_id")
    private Pedido pedido;

}
