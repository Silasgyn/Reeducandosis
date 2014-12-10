package br.com.ambientinformatica.reeducandosis.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Cela {
	@Id
	@GeneratedValue(generator = "cela_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "cela_seq", sequenceName = "cela_seq", allocationSize = 1, initialValue = 1)
	private int id;
	private int numerodacela;
	private String unidadePrisional;
		
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumerodacela() {
		return numerodacela;
	}

	public void setNumerodacela(int numerodacela) {
		this.numerodacela = numerodacela;
	}

	public String getUnidadePrisional() {
		return unidadePrisional;
	}

	public void setUnidadePrisional(String unidadePrisional) {
		this.unidadePrisional = unidadePrisional;
	}


}
