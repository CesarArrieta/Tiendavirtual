
package com.TiendaApu.repositorios;

import com.TiendaApu.entidades.Categorias;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoriasRepositorio extends JpaRepository<Categorias, Integer>{
    
   public List<Categorias> findByNombreContainingOrDepartamentoContaining (String criterio1, String criterio2);
   
   //public List<Categorias> finByHabTrue();
}
