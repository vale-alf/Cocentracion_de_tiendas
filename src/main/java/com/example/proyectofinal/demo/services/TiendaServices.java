/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.demo.services;

import com.example.proyectofinal.demo.clases.Tienda;
import com.example.proyectofinal.demo.clases.repositorio.TiendaRepositorio;
import com.example.proyectofinal.demo.repositorioServices.RTiendaServices;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 *
 * @author vale
 */
@Service
public class TiendaServices implements RTiendaServices{

    @Autowired
    private TiendaRepositorio data;
    
    @Override
    public List<Tienda> Listar() {
        
        return (List<Tienda>)data.findAll();
    }
   
    
    @Override
    public Optional<Tienda> ListarId(int id) {
        return data.findById(id);
    }

    @Override
    public int save(Tienda T) {
        Tienda tienda=data.save(T);
        return 0;
        
    }

    @Override
    public void delete(int id) {
      data.deleteById(id);
    }

   
    
}
