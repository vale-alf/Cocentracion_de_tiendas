/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectofinal.demo.clases.repositorio;

import com.example.proyectofinal.demo.clases.Producto;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vale
 */
@Repository
public interface ProductoReposi extends CrudRepository<Producto, Integer> {

    @Query("Select p FROM Producto p WHERE p.nombre LIKE %?1%"+"OR p.categoria LIKE %?1%")
    public List<Producto> findAll(String palabraClave);
}
