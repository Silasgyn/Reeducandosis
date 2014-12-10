package br.com.ambientinformatica.reeducandosis.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity
public class Alcunha {
		
	@Id
	 @GeneratedValue(generator="alcunha_seq", strategy=GenerationType.SEQUENCE)
	 @SequenceGenerator(name="alcunha_seq",sequenceName="alcunha_seq",allocationSize=1,initialValue=1)
	private Integer id;
	private String apelido;
	private boolean ativo = true;
	
	
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	public boolean isAtivo() {
		return ativo;
	}
	

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

}
