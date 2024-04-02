package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.entities.DetalleEnvio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetalleEnvioRepository extends JpaRepository<DetalleEnvio, Long> {
    List<DetalleEnvio> findByPedidoId(Long pedidoId);

    List<DetalleEnvio> findByTrasnportadora(String transportadora);
}
