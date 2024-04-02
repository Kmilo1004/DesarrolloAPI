package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.AbstractIntegrationDBTest;
import com.example.DesarrolloAPI.entities.ItemPedido;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class ItemPedidoRepositoryTest extends AbstractIntegrationDBTest {

    ItemPedidoRepository itemPedidoRepository;

    public  ItemPedidoRepositoryTest(ItemPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }

   /* void initMockItemPedido(){
        ItemPedido itemPedido = ItemPedido.builder()
                .cantidad(2)
                .precioUnitario(25)
                .pedido(1l)
    }*/

    @BeforeEach
    void setUp() {

    }

}