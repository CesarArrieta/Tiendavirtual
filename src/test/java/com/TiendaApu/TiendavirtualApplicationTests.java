package com.TiendaApu;

import com.TiendaApu.entidades.Categorias;
import com.TiendaApu.servicios.CategoriaServicios;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TiendavirtualApplicationTests {
    
        @Autowired//inyeccion de dependencia//
        private CategoriaServicios servicio;
   
	@Test
        @Disabled
	void verificarSiGuardaUnaCategoria() {
            Categorias c = new Categorias("Ropa casual para hombre", "hombre casual", true );
            Categorias guardado = servicio.crearNuevaCategoria(c);
            Assertions.assertTrue(guardado.getId() > 0, "ERROR, no se pudo guardar categoria nueva");
	}
       
        @Test
        @Disabled
	void verificarSiActualizaUnaCategoria() {
            Categorias c = new Categorias("Ropa deportiva para mujer", "mujer deportiva", true );
            Categorias guardado = servicio.crearNuevaCategoria(c);
            guardado.setDepartamento("mujer formal");
            guardado.setHab(false);
            Categorias actualizada = servicio.actualizarCategoria(guardado);
            Assertions.assertTrue(actualizada.getDepartamento().equals("mujer formal"), "ERROR, no se pudo actualizar categoria"); 
            Assertions.assertTrue(actualizada.isHab() == false, "ERROR, no se pudo actualizar categoria");  
        }
          
        @Test
        @Disabled
	void verificarSiEncuentraTodasLasCategorias() {
            List <Categorias> listado = servicio.consultarCategorias();
            Assertions.assertTrue ( listado.size() > 0 , "No se encontraron categorías" );
        }
        
        @Test
        @Disabled
        void probarSiEncuentraCategoriaConId() {
            Categorias  cat = servicio.consultarCategorias(1);
            Assertions.assertNotNull(cat, "No se encontró categoría");
        }
        
        @Test
        @Disabled
        void probarEliminarCategoria(){
        Categorias c = new Categorias("hhh", "jjj", true );
        Categorias guardada = servicio.crearNuevaCategoria(c);
        Assertions.assertTrue(guardada.getId() > 0, "No se pudo crear categoria para borrar");
        servicio.eliminarCategorias(guardada);
        Categorias eliminada = servicio.consultarCategorias(guardada.getId());
        Assertions.assertNull(eliminada, "no se eliminó categoria");
        }
        
}