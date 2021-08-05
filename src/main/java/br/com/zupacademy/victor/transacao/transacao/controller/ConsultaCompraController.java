package br.com.zupacademy.victor.transacao.transacao.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zupacademy.victor.transacao.transacao.dto.DetalheTrasansacao;
import br.com.zupacademy.victor.transacao.transacao.model.Transacao;
import br.com.zupacademy.victor.transacao.transacao.repository.TransacaoRepository;

@RestController
@RequestMapping("/api/transacoes")
public class ConsultaCompraController {

	private TransacaoRepository transacaoRepository;

	public ConsultaCompraController(TransacaoRepository transacaoRepository) {
		this.transacaoRepository = transacaoRepository;
	}

	@GetMapping("/{numero}")
	public ResponseEntity<Page<DetalheTrasansacao>> lista(@PathVariable String numero,
			@PageableDefault(sort = "efetivadaEm", direction = Direction.DESC, page = 0, size = 10) Pageable paginacao) {
		
		Page<Transacao> transacoes = transacaoRepository.findByCartaoNumero(numero, paginacao);
		
		if (transacoes.isEmpty()) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(DetalheTrasansacao.converte(transacoes));
	}
}
