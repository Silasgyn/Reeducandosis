package br.com.ambientinformatica.reeducandosis.persistencia;



import org.springframework.stereotype.Repository;
import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.reeducandosis.entidade.Reeducando;

@Repository("reeducandoDao")
public class ReeducandoDaoJpa extends PersistenciaJpa<Reeducando> implements
		ReeducandoDao {

	private static final long serialVersionUID = 1L;
	
	
	
}
