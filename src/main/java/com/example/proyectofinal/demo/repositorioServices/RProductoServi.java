/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectofinal.demo.repositorioServices;

import com.example.proyectofinal.demo.clases.Producto;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author vale
 */
public interface RProductoServi {

    public List<Producto> Listar();

    public Optional<Producto> ListarId(int id);

    public int save(Producto p);

    public void delete(int id);
    
}
