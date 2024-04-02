package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.entities.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {
    List<Pago> findByFechaPagoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<Pago> findByPedidoIdAndMetodoPago(Long pedidoId, Pago.MetodoPago metodoPago);
}

