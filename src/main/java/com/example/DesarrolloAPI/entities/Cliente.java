package com.example.DesarrolloAPI.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name= "Cliente")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String nombre;
    private String email;
    private String direccion;
    @OneToMany(mappedBy = "Cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    private List<Pedido> Pedido;
}
