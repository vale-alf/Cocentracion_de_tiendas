/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.demo.controller;

import com.example.proyectofinal.demo.clases.Tienda;
import com.example.proyectofinal.demo.repositorioServices.RTiendaServices;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

/**
 *
 * @author vale
 */
@Controller
@RequestMapping("/Usuario")
public class TiendaUserController {

    @Autowired
    private RTiendaServices Services;

    @GetMapping("/Tienda")
    public String listar(Model model) {
        List<Tienda> Tienda = Services.Listar();
        model.addAttribute("Tienda", Tienda);
        return "Usuario_tiendas";
    }

}
