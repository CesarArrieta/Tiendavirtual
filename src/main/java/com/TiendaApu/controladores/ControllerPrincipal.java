
package com.TiendaApu.controladores;

/*//index. html            /
//lista categorias html    /categorias
//formulario. html         /categorias/formu/id
*/

import com.TiendaApu.entidades.Categorias;
import com.TiendaApu.servicios.CategoriaServicios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;    

@Controller
public class ControllerPrincipal {

@Autowired
    private CategoriaServicios servicio;
            
    @GetMapping("/")
    public String cargarIndex(){
      return "index";
    }
    
    
    @GetMapping("/categorias")
    public String cargarListaCategorias(Model model, @RequestParam(value="criterio", required=false) String criterio){
      
       if (criterio == null){
       model.addAttribute("categorias", servicio.consultarCategorias());
       
       }   
       
       else{
       model.addAttribute("categorias", servicio.consultarCategorias(criterio));
       model.addAttribute("criterio", criterio);
       }
       return "listacategorias";
       
    }
       
    @GetMapping("/categorias/form")
       public String cargarFormuCategorias(Model modelo){
       modelo.addAttribute("categoria", new Categorias());
       return "formcategorias";
    } 
    @GetMapping("/categorias/form/{id}")
       public String cargarFormuCategorias(Model modelo, @PathVariable int id){
       Categorias c = servicio.consultarCategorias(id);      
       modelo.addAttribute("categoria", c);
       return "formcategorias";
       
       } 
    
    @PostMapping("/categorias")
    public String guardarCategorias(@ModelAttribute Categorias c){
        servicio.crearNuevaCategoria(c);
        return "redirect:/categorias";
    }
    
     @GetMapping("/categorias/eliminar/{id}")
       public String elimninarCategoria (@PathVariable int id){
       Categorias c = servicio.consultarCategorias(id);      
       servicio.eliminarCategorias(c);
       return "redirect:/categorias";
       
    }
       
}

    

