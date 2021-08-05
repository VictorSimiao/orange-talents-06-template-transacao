package br.com.zupacademy.victor.transacao.transacao.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.hibernate.annotations.CreationTimestamp;

import com.sun.istack.NotNull;

import br.com.zupacademy.victor.transacao.cartao.Cartao;
import br.com.zupacademy.victor.transacao.estabelecimento.Estabelecimento;

@Entity
public class Transacao {

	@Id
	@NotBlank
	private String id;

	@NotNull
	@Positive
	private BigDecimal valor;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
	private Estabelecimento estabelecimento;

	@NotNull
	@ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.PERSIST)
	private Cartao cartao;

	@NotNull
	@CreationTimestamp
	private LocalDate efetivadaEm;

	@Deprecated
	public Transacao() {

	}

	public Transacao(@NotBlank String id, @Positive BigDecimal valor, Estabelecimento estabelecimento, Cartao cartao,
			LocalDate efetivadaEm) {
		this.id = id;
		this.valor = valor;
		this.estabelecimento = estabelecimento;
		this.cartao = cartao;
		this.efetivadaEm = efetivadaEm;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public LocalDate getEfetivadaEm() {
		return efetivadaEm;
	}

	public String getNomeEstabelecimento() {
		return estabelecimento.getNome();
	}
}
