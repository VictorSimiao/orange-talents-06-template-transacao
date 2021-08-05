package br.com.zupacademy.victor.transacao.transacao.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zupacademy.victor.transacao.transacao.model.Transacao;

public interface TransacaoRepository extends JpaRepository<Transacao, Long> {

	Page<Transacao> findByCartaoNumero(String numero, Pageable paginacao);
}
