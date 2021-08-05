package br.com.zupacademy.victor.transacao.cartao.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zupacademy.victor.transacao.cartao.Cartao;

public class CartaoResponse {

	@NotBlank
	private String id;

	@NotBlank
	@Email
	private String email;

	@Deprecated
	public CartaoResponse() {
		
	}

	public CartaoResponse(@NotBlank String id, @NotBlank @Email String email) {
		this.id = id;
		this.email = email;
	}
	
	public String getId() {
		return id;
	}
	
	public String getEmail() {
		return email;
	}

	public Cartao toModel() {
		return new Cartao(id, email);
	}
	
}
