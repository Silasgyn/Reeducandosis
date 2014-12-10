package br.com.ambientinformatica.reeducandosis.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.reeducandosis.entidade.Historico;

@Repository("historicoDao")
public class HistoricoDaoJpa  extends PersistenciaJpa<Historico> implements HistoricoDao {
	   private static final long serialVersionUID = 1L;
	   
		

}
