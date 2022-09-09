
package com.TiendaApu.servicios;

import com.TiendaApu.entidades.Categorias;
import com.TiendaApu.repositorios.ICategoriasRepositorio;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServicios {
    
    
    @Autowired /**Inyección*/
    private ICategoriasRepositorio repo;
    
    public  Categorias crearNuevaCategoria(Categorias c){
        Categorias guardado = repo.save(c);//metodos delrepositorio//
        return guardado;
    }
    
    public Categorias actualizarCategoria(Categorias c){
        Categorias guardado = repo.save(c);//metodos delrepositorio//
        return guardado; 
    }
    
    public List<Categorias> consultarCategorias(){
      List<Categorias> lista = repo.findAll();//metodos delrepositorio//
      return lista;
    }
    
    public Categorias consultarCategorias(int id){
      Categorias c = repo.findById(id).orElse(null);//metodos delrepositorio//
      return c;
    }
      
    /*public List<Categorias> consultarCategoriasHabilitadas(){
        List<Categorias> lista = repo.finByHabTrue();//metodos delrepositorio//
        return lista;
    }*/
      
   public List<Categorias> consultarCategorias(String criterio){
      List<Categorias> lista = repo.findByNombreContainingOrDepartamentoContaining(criterio, criterio);
      return lista;
    }

    public void eliminarCategorias(Categorias c){
        repo.delete(c);
    }
}
