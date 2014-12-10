package br.com.ambientinformatica.reeducandosis.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Reeducando {

	@Id
	@GeneratedValue(generator = "reeducando_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "reeducando_seq", sequenceName = "reeducando_seq", allocationSize = 1, initialValue = 1)
	private Integer id;
	private String nome;
	private String nomedopai;
	private String nomedamae;
	private String cpf;
	private String rg;
	@OneToOne
	private Endereco endereco;
	@OneToOne
	private Alcunha alcunha;

	public Reeducando() {
		super();
		endereco = new Endereco();
		alcunha = new Alcunha();
	}

	public Reeducando(Integer id, String nome, String nomedopai,
			String nomedamae, String cpf, String rg, Endereco endereco,
			Alcunha alcunha) {
		super();
		this.id = id;
		this.nome = nome;
		this.nomedopai = nomedopai;
		this.nomedamae = nomedamae;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.alcunha = alcunha;
	}



	public Integer getId() {
		return id;
	}

	
	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNomedopai() {
		return nomedopai;
	}

	public void setNomedopai(String nomedopai) {
		this.nomedopai = nomedopai;
	}

	public String getNomedamae() {
		return nomedamae;
	}

	public void setNomedamae(String nomedamae) {
		this.nomedamae = nomedamae;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Alcunha getAlcunha() {
		return alcunha;
	}

	public void setAlcunha(Alcunha alcunha) {
		this.alcunha = alcunha;
	}
	
	public Integer toInteger(){
		return this.getId();
	}
	
	

}
