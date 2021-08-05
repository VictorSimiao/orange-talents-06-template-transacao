package br.com.zupacademy.victor.transacao.transacao;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import br.com.zupacademy.victor.transacao.cartao.dto.CartaoResponse;
import br.com.zupacademy.victor.transacao.estabelecimento.EstabelecimentoResponse;

public class EventoDeTransacao {

	@NotBlank
	private String id;

	@Positive
	private BigDecimal valor;

	@NotNull
	private EstabelecimentoResponse estabelecimento;

	@NotNull
	private CartaoResponse cartao;

	@NotNull
	private LocalDate efetivadaEm;

	@Deprecated
	public EventoDeTransacao() {

	}

	public EventoDeTransacao(@NotBlank String id, @Positive BigDecimal valor,
			@NotNull EstabelecimentoResponse estabelecimento, @NotNull CartaoResponse cartao,
			@NotNull LocalDate efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}


	public String getId() {
		return id;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public EstabelecimentoResponse getEstabelecimento() {
		return estabelecimento;
	}

	public CartaoResponse getCartao() {
		return cartao;
	}

	public LocalDate getEfetivadaEm() {
		return efetivadaEm;
	}

	public Transacao toModel() {
		return new Transacao(id, valor, estabelecimento.toModel(), cartao.toModel(), efetivadaEm);
	}

}
