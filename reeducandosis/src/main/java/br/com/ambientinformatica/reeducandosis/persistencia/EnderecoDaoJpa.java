package br.com.ambientinformatica.reeducandosis.persistencia;

import org.springframework.stereotype.Repository;

import br.com.ambientinformatica.jpa.persistencia.PersistenciaJpa;
import br.com.ambientinformatica.reeducandosis.entidade.Endereco;

@Repository("enderecoDao")
public class EnderecoDaoJpa extends PersistenciaJpa<Endereco> implements EnderecoDao {
	   private static final long serialVersionUID = 1L;

}