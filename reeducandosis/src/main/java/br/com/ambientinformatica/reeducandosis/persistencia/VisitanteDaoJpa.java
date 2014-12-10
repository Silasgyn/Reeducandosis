package br.com.ambientinformatica.reeducandosis.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.reeducandosis.entidade.Visitante;

@Repository("visitanteDao")
public class VisitanteDaoJpa  extends PersistenciaJpa<Visitante> implements VisitanteDao {
	   private static final long serialVersionUID = 1L;

}
