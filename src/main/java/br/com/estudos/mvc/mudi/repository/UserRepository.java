package br.com.estudos.mvc.mudi.repository;


import br.com.estudos.mvc.mudi.model.Pedido;
import br.com.estudos.mvc.mudi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, String> {
//    @Query("SELECT u FROM User u join u.pedido p where u.username = :username")
    User findByUsername(String username);

}
