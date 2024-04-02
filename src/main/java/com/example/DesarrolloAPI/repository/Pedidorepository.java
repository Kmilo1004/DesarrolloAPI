package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.entities.Cliente;
import com.example.DesarrolloAPI.entities.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
@Repository
public interface Pedidorepository extends JpaRepository<Pedido, Long> {
    List<Pedido> findByFechaPedidoBetween(LocalDateTime fechaInicio, LocalDateTime fechaFin);

    List<Pedido> findByClienteAndStatus(Cliente cliente, String status);

    @Query("SELECT DISTINCT p FROM Pedido p JOIN FETCH p.itemPedido WHERE p.cliente = :cliente")
    List<Pedido> findByClienteWithItemsPedido(Cliente cliente);
}
