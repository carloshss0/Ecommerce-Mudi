package br.com.estudos.mvc.mudi.repository;

import br.com.estudos.mvc.mudi.model.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {

    @Query("SELECT o from Oferta o where o.user.username != :username")
    List<Oferta> findByUser(@Param("username") String username);
}
