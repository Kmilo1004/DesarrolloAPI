package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "clientes")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String email;
    private String direccion;
    @OneToMany(mappedBy = "clientes")
    private List<Pedido> pedidos;
}
