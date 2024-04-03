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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String direccion;
    private String transportadora;
    private String numeroGuia;
    @OneToOne
    @JoinColumn(name = "id_detalle_envio")
    private Pedido pedidos;


}
