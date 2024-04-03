package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.AbstractIntegrationDBTest;
import com.example.DesarrolloAPI.entities.Cliente;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
class ClienteRepositoryTest extends AbstractIntegrationDBTest {
    @Autowired
    ClienteRepository clienteRepository;

    /*public ClienteRepositoryTest(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }*/
    @BeforeEach
    void setUp() {
    clienteRepository.deleteAll();
    }

    @Test
    void buscarClientePorCorreo() {
    //Given
    Cliente cliente = Cliente.builder()
                    .email("and@gmsil.com")
                    .direccion("calle4")
                    .nombre("camilo andres")
            .build();
    clienteRepository.save(cliente);
    //When
    List<Cliente> clienteSeach = clienteRepository.findByEmail("and@gmsil.com");
    //Then
    assertThat(clienteSeach).isNotEmpty();
    assertThat(clienteSeach.get(0).getEmail()).isEqualTo("and@gmail.com");
    }

    @Test
    void buscarPorDireccion() {
    //Given
        Cliente cliente1 = Cliente.builder()
                .email("moi@gmsil.com")
                .direccion("calle7")
                .nombre("andres")
                .build();
        clienteRepository.save(cliente1);
    //When
        List<Cliente> clientesd = clienteRepository.findByDireccion("calle7");
    //Then
        assertThat(clientesd).isNotEmpty();
        assertThat(clientesd.get(0).getDireccion()).isEqualTo("Calle 7");
    }

    @Test
    void BuscarListaDeClientesPorNombres() {
        //Given
        Cliente cliente1 = Cliente.builder()
                .email("moi@gmail.com")
                .direccion("Calle 3")
                .nombre("Camilo")
                .build();
        Cliente cliente2 = Cliente.builder()
                .email("otro@gmail.com")
                .direccion("calle 5")
                .nombre("Andres")
                .build();
        clienteRepository.save(cliente1);
        clienteRepository.save(cliente2);
        //When
        List<Cliente> clientesN = clienteRepository.findByNombreStartingWithIgnoreCase("Camilo");
        //Then
        assertThat(clientesN).hasSize(2);
    }
}

