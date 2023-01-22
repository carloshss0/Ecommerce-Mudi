package br.com.estudos.mvc.mudi.dto;

import br.com.estudos.mvc.mudi.model.Oferta;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

public class OfertaDto {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private Long ofertaId;
    private Long pedidoId;
    private String usuarioQueFezAOferta;
    private String nomeProduto;
    private String urlImagem;
    private String urlProduto;
    private BigDecimal valor;
    private String dataDaEntrega;
    private String comentario;

    public OfertaDto(Oferta oferta) {
        this.ofertaId = oferta.getId();
        this.pedidoId = oferta.getPedido().getId();
        this.usuarioQueFezAOferta = oferta.getUser().getUsername();
        this.nomeProduto = oferta.getPedido().getNomeProduto();
        this.urlImagem = oferta.getPedido().getUrlImagem();
        this.urlProduto = oferta.getPedido().getUrlProduto();
        this.valor = oferta.getValor();
        this.dataDaEntrega = oferta.getDataDaEntrega().format(formatter);
        this.comentario = oferta.getComentario();

    }

    public static List<OfertaDto> converter(List<Oferta> ofertas) {
        return ofertas.stream()
                .map(OfertaDto::new)
                .collect(Collectors.toList());
    }

    public Long getOfertaId() {
        return ofertaId;
    }

    public Long getPedidoId() {
        return pedidoId;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public String getDataDaEntrega() {
        return dataDaEntrega;
    }

    public String getComentario() {
        return comentario;
    }

    public String getUsuarioQueFezAOferta() {
        return usuarioQueFezAOferta;
    }
}
