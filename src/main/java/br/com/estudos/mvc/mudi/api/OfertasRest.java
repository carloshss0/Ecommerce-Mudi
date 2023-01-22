package br.com.estudos.mvc.mudi.api;

import br.com.estudos.mvc.mudi.dto.OfertaDto;
import br.com.estudos.mvc.mudi.dto.RequisicaoNovaOferta;
import br.com.estudos.mvc.mudi.model.Oferta;
import br.com.estudos.mvc.mudi.model.Pedido;
import br.com.estudos.mvc.mudi.model.User;
import br.com.estudos.mvc.mudi.repository.OfertaRepository;
import br.com.estudos.mvc.mudi.repository.PedidoRepository;
import br.com.estudos.mvc.mudi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ofertas")
public class OfertasRest {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public Oferta criaOferta(@Valid @RequestBody RequisicaoNovaOferta requisicao) {

        Optional<Pedido> pedidoBuscado = pedidoRepository.findById(requisicao.getPedidoId());
        if(!pedidoBuscado.isPresent()) {
            return null;
        }
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        User user = userRepository.findByUsername(username);
        Pedido pedido = pedidoBuscado.get();
        Oferta nova = requisicao.toOferta();
        nova.setPedido(pedido);
        nova.setUser(user);


        pedido.getOfertas().add(nova);
        pedidoRepository.save(pedido);
        return nova;
    }

    @GetMapping("/pedidosOfertas")
    public List<OfertaDto> ofertas() {
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        List<Oferta> ofertas = ofertaRepository.findByUser(username);
        return OfertaDto.converter(ofertas);
    }


}
