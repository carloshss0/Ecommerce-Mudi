package br.com.estudos.mvc.mudi.api;


import br.com.estudos.mvc.mudi.model.Pedido;
import br.com.estudos.mvc.mudi.model.StatusPedido;
import br.com.estudos.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
public class PedidosRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("aguardando")
    public List<Pedido> getPedidosAguardandoOfertas() {
        Sort sort = Sort.by("id").descending();
        PageRequest paginacao = PageRequest.of(0, 10, sort);
        String username = SecurityContextHolder.getContext().getAuthentication().getName();


        return pedidoRepository.findByStatusAndNotUsuario(StatusPedido.AGUARDANDO, paginacao, username);
    }




}
