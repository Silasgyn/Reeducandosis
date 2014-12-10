package br.com.ambientinformatica.reeducandosis.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Endereco {
	@Id
	 @GeneratedValue(generator="endreeducando_seq", strategy=GenerationType.SEQUENCE)
	 @SequenceGenerator(name="endreeducando_seq",sequenceName="endreeducando_seq",allocationSize=1,initialValue=1)
	private Integer id;
	
	private String logradouro;
	private String complemento;
	private String setor;
	private String cidade;
	private String estado;
	private String cep;
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
}
