/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.demo.controller;


import com.example.proyectofinal.demo.clases.Producto;
import com.example.proyectofinal.demo.clases.Tienda;
import com.example.proyectofinal.demo.repositorioServices.RProductoServi;
import com.example.proyectofinal.demo.repositorioServices.RTiendaServices;

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
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("Tienda")
public class TiendaController {
    @Autowired
    private RTiendaServices Services;
    
     
    @GetMapping("/Add")
    public String listar(Model model){
       List<Tienda>Tienda=Services.Listar();
       model.addAttribute("Tienda", Tienda);
        return "Admin_tiendas";   
    }
    
    @GetMapping("/New")
    public String Agregar(Model model){
        model.addAttribute("Tienda", new Tienda());
        return "Agregar_tienda";
    }
    @PostMapping("/save")
    public String save(@Valid Tienda t,Model model){
       Services.save(t);
       return "redirect:/Tienda/Add";
    }
    @GetMapping("/edit/{id}")
    public String editar(@PathVariable int id, Model model)
    {
        Optional<Tienda>Tienda=Services.ListarId(id);
        model.addAttribute("Tienda",Tienda);
       return "Agregar_tienda";
 
    }
     @GetMapping("/delete/{id}")
     public String delete (Model model, @PathVariable int id){
         Services.delete(id);
         return "redirect:/Tienda/Add";
     }

    
}
