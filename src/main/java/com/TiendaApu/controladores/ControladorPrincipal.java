
package com.TiendaApu.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ControladorPrincipal {
<<<<<<< Updated upstream
    
    @GetMapping("/")
    public String cargarIndex(){
      return "index";
    }
    
    @GetMapping("/productos")
    public String cargarListaProductos(){
    
    return "listaproductos";
    }
}
    
=======
    @GetMapping("/")
    public String cargarIndex(){
        return "index";
    }    
    @GetMapping("/productos")
    public String catalogoProductos(){
        return "lista_productos";
    }  
     
}
>>>>>>> Stashed changes
