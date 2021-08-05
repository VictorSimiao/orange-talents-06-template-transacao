package br.com.zupacademy.victor.transacao.transacao.listen;

import javax.persistence.EntityManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.zupacademy.victor.transacao.transacao.evento.EventoDeTransacao;

@Component
public class ListenerDeTransacao {

	private EntityManager manger;
    private final Logger log = LoggerFactory.getLogger(ListenerDeTransacao.class);
    
	public ListenerDeTransacao(EntityManager manger) {
		this.manger = manger;
	}

	@Transactional
	@KafkaListener(topics = "${spring.kafka.topic.transactions}")
	public void ouvir(EventoDeTransacao evento) {
			manger.persist(evento.toModel());
			log.info("Transação registrada com sucesso");
	}
}
