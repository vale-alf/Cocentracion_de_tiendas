/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.demo.services;

import com.example.proyectofinal.demo.clases.Producto;
import com.example.proyectofinal.demo.clases.repositorio.ProductoReposi;
import com.example.proyectofinal.demo.repositorioServices.RProductoServi;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author vale
 */
@Service
public class ProductoServices implements RProductoServi {

    @Autowired
    private ProductoReposi data2;

    @Override
    public List<Producto> Listar() {

        return (List<Producto>) data2.findAll();
    }
     
    @Override
    public Optional<Producto> ListarId(int id) {
        return data2.findById(id);
    }

    @Override
    public int save(Producto p) {

        Producto producto = data2.save(p);
        return 0;
    }

    @Override
    public void delete(int id) {
        data2.deleteById(id);
    }
    
    public List<Producto> listAll(String palabraClave){
        if (palabraClave!=null) {
            return data2.findAll(palabraClave);
        }
        
        return (List<Producto>) data2.findAll();
    }

}
