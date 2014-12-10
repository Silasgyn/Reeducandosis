package br.com.ambientinformatica.reeducandosis.entidade;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Visitante {

	@Id
	@GeneratedValue(generator = "visitante_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "visitante_seq", sequenceName = "visitante_seq", allocationSize = 1, initialValue = 1)
	private int id;
	private String nome;
	private String telefone;
	private String cpf;
	@OneToOne
	private Endereco endereco;
	
	
	private String parentesco;
	
	
	
	public Visitante() {
		super();
		endereco = new Endereco();
	}
	
	
	public Visitante(int id, String nome, String telefone, String cpf,
			Endereco endereco, String parentesco) {
		super();
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.cpf = cpf;
		this.endereco = endereco;
		this.parentesco = parentesco;
	}



	public int getId() {
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

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getParentesco() {
		return parentesco;
	}

	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}

	
	
}
