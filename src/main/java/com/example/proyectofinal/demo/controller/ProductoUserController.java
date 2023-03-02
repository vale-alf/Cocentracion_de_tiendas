/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.demo.controller;

import com.example.proyectofinal.demo.clases.Producto;
import com.example.proyectofinal.demo.services.ProductoServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/Producto")
public class ProductoUserController {

    @Autowired
    private ProductoServices services;

    @GetMapping("/Buscar")
    public String listarProductosBusqueda(Model model,@Param("palabraClave")String palabraClave) {
         
        List<Producto> producto = services.listAll(palabraClave);
        model.addAttribute("Producto", producto);
        model.addAttribute("palabraClave", palabraClave);
        return "Buscar_usuario";

    }
}
