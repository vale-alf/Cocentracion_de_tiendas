/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.demo.controller;

import com.example.proyectofinal.demo.clases.Producto;
import com.example.proyectofinal.demo.services.ProductoServices;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vale
 */
@Controller
@RequestMapping("/Producto")
public class ProductoController { 
   @Autowired
   private ProductoServices services;
   
   @GetMapping("/Add")
    public String listar(Model model){
      
       List<Producto>producto=services.Listar();
       model.addAttribute("Producto", producto);
        return "Admin_productos";   
    }
    
  
    
    
    @GetMapping("/New")
    public String Agregar(Model model){
        model.addAttribute("Producto", new Producto());
        return "Agregar_producto";
    }
    
    
    @PostMapping("/Save")
    public String save(@Valid Producto p,Model model){
       services.save(p);
       return "redirect:/Producto/Add";
    }
    
    
    
    @GetMapping("/edit/{id}")
    
    public String editar(@PathVariable int id, Model model)
    {
        Optional<Producto>producto=services.ListarId(id);
        model.addAttribute("Producto",producto);
       return "Agregar_producto";
 
    }
     @GetMapping("/delete/{id}")
     public String delete (Model model, @PathVariable int id){
         services.delete(id);
         return "redirect:/Producto/Add";
     }

   
}
