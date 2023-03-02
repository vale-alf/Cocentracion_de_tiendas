/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectofinal.demo.clases.repositorio;

import com.example.proyectofinal.demo.clases.Tienda;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author vale
 */
@Repository
public interface TiendaRepositorio extends CrudRepository<Tienda, Integer>{
    
}
