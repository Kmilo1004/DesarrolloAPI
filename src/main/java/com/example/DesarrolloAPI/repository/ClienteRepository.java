package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;
@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    List<Cliente> findByEmail(String email);

    List<Cliente> findByDireccion(String direccion);

    List<Cliente> findByNombreStartingWithIgnoreCase( String nombre);
}
