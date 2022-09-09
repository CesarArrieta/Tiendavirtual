
package com.TiendaApu.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
    
    @GetMapping("/")
    public String cargarIndex(){
      return "index";
    }
    
    @GetMapping("/productos")
    public String cargarListaProductos(){
    
    return "listaproductos";
    }
}
    
