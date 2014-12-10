package br.com.ambientinformatica.reeducandosis.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.reeducandosis.entidade.Cela;

@Repository("celaDao")
public class CelaDaoJpa  extends PersistenciaJpa<Cela> implements CelaDao {
	   private static final long serialVersionUID = 1L;

}
