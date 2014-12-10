package br.com.ambientinformatica.reeducandosis.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.reeducandosis.entidade.Alcunha;

@Repository("alcunhaDao")
public class AlcunhaDaoJpa  extends PersistenciaJpa<Alcunha> implements AlcunhaDao {
	   private static final long serialVersionUID = 1L;

}
