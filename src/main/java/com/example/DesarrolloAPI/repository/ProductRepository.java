package com.example.DesarrolloAPI.repository;

import com.example.DesarrolloAPI.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNombre(String term);

    List<Product> findByStock(Integer stock);

    List<Product> findByPriceLessThanEqualAndStockLessThanEqual(Double maxPrice, Integer maxStock);
}
