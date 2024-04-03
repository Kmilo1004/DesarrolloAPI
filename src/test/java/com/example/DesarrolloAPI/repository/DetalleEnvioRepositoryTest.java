package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.AbstractIntegrationDBTest;
import com.example.DesarrolloAPI.entities.DetalleEnvio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;


class DetalleEnvioRepositoryTest extends AbstractIntegrationDBTest {
    @Autowired
    DetalleEnvioRepository detalleEnvioRepository;


    /*public DetalleEnvioRepositoryTest(DetalleEnvioRepository detalleEnvioRepository) {
        this.detalleEnvioRepository = detalleEnvioRepository;
    }*/

    void initMockDetalles(){

        DetalleEnvio detalleEnvio = DetalleEnvio.builder()
                //.pedido(pedido)
                .direccion("Calle 22")
                .transportadora("envia")
                .numeroGuia("1212")
                .build();
        detalleEnvioRepository.save(detalleEnvio);

        DetalleEnvio detalleEnvio2 = DetalleEnvio.builder()
                //.pedido(pedido)
                .direccion("Carrera 1")
                .transportadora("Servientrega")
                .numeroGuia("1515")
                .build();
        detalleEnvioRepository.save(detalleEnvio2);
        detalleEnvioRepository.flush();
    }

    @BeforeEach
    void setUp() {
        detalleEnvioRepository.deleteAll();
    }

    @Test
    @DisplayName("Buscas todos los detalles del envio que tenemos")
        void shouldGetAllDetalleEnvio(){
        //given
        initMockDetalles();

        //when
        List<DetalleEnvio> detalleEnvios = detalleEnvioRepository.findAll();

        //then
        assertThat(detalleEnvios).hasSize(2);
    }

    @Test
    void givenDetalleEnvio_whenBuscarLaTransportadora_thenObtienesUnaListaDeTransportadoras(){
        initMockDetalles();

        List<DetalleEnvio> detalleEnvios = detalleEnvioRepository.findByTransportadora("envia");

        assertThat(detalleEnvios).isNotEmpty();
        assertThat(detalleEnvios).first().hasFieldOrPropertyWithValue("transportadora", "envia");
        assertThat(detalleEnvios).first().hasFieldOrPropertyWithValue("transportadora", "Servientrega");
    }

    @Test
    void givenDetalleEnvio_whenBuscarId_thenObtienesUnaListaDeDetallesEnvios(){
        initMockDetalles();

        List<DetalleEnvio> detalleEnvios = detalleEnvioRepository.findByPedidoId(1L);

        assertThat(detalleEnvios).isNotEmpty();
        assertThat(detalleEnvios).first().hasFieldOrPropertyWithValue("numeroGuia", "1212");
        assertThat(detalleEnvios).first().hasFieldOrPropertyWithValue("direccion", "Calle 22");
    }
}
