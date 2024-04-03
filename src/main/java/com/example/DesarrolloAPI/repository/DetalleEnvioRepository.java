package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.entities.DetalleEnvio;
import com.example.DesarrolloAPI.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DetalleEnvioRepository extends JpaRepository<DetalleEnvio, Long> {
    List<DetalleEnvio> findByPedidoId(Long pedidoId);

    List<DetalleEnvio> findByTransportadora(String transportadora);

    List<DetalleEnvio> findByEstadoPedido(Pedido.Status estado);
}
