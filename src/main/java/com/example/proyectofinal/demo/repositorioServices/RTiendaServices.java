/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.example.proyectofinal.demo.repositorioServices;

import com.example.proyectofinal.demo.clases.Tienda;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author vale
 */
public interface RTiendaServices {
    public List<Tienda>Listar();
    public Optional<Tienda>ListarId(int id);
    public int save(Tienda T);
    public void delete(int id);
}
