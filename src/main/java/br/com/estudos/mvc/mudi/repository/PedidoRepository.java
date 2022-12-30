package br.com.estudos.mvc.mudi.repository;

import br.com.estudos.mvc.mudi.model.Pedido;
import br.com.estudos.mvc.mudi.model.StatusPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {

    List<Pedido> findByStatus(StatusPedido status);
}
