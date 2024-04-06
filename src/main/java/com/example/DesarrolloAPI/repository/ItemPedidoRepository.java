package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.entities.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
    List<ItemPedido> findByPedidoId(Long pedidoId);

    List<ItemPedido> findByProduct_Id(Long productId);

    @Query("SELECT SUM(ip.cantidad * ip.precioUnitario) FROM ItemPedido ip WHERE ip.product.id = :productId")
    Double calcularTotalVentasProducto(Long productId);
}
