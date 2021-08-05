package br.com.zupacademy.victor.transacao.transacao.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.data.domain.Page;

import com.sun.istack.NotNull;

import br.com.zupacademy.victor.transacao.transacao.model.Transacao;

public class DetalheTrasansacao {

	@NotNull
	@Positive
	private BigDecimal valor;

	@NotBlank
	private String estabelecimento;

	@NotNull
	private LocalDate efetivadaEm;

	public DetalheTrasansacao(Transacao transacao) {
		this.valor = transacao.getValor();
		this.estabelecimento = transacao.getNomeEstabelecimento();
		this.efetivadaEm = transacao.getEfetivadaEm();
	}

	public BigDecimal getValor() {
		return valor;
	}

	public String getEstabelecimento() {
		return estabelecimento;
	}

	public LocalDate getEfetivadaEm() {
		return efetivadaEm;
	}

	public static Page<DetalheTrasansacao> converte(Page<Transacao> transacoes) {
		return transacoes.map(DetalheTrasansacao::new);
	}
}
