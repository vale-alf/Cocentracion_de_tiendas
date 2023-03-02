/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.proyectofinal.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author vale
 */
@Controller 
@RequestMapping("/Usuario")
public class PrincipalUserController {
    @GetMapping("/Panel")
    public String Panel()
    {
        return "Principal_usuario";
    }
    
     @GetMapping("/Producto")
    public String Producto()
    {
        return "Buscar_usuario";
    }
}
