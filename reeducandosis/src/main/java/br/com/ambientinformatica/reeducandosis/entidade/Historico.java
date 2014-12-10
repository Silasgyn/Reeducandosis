package br.com.ambientinformatica.reeducandosis.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.ambientinformatica.reeducandosis.entidade.Regime;
import br.com.ambientinformatica.reeducandosis.entidade.Cela;

@Entity
public class Historico {

	@Id
	@GeneratedValue(generator = "historico_seq", strategy = GenerationType.SEQUENCE)
	@SequenceGenerator(name = "historico_seq", sequenceName = "historico_seq", allocationSize = 1, initialValue = 1)
	private int id;
	@Enumerated(EnumType.ORDINAL)
	// grava numeral de acordo com a ordem do Enumerador
	private Regime regime;
	private String descricao;

	@Temporal(TemporalType.DATE)
	private Date dtHistorico = new Date();

	@ManyToOne
	private Reeducando reeducando = new Reeducando();
	@ManyToOne
	private Visitante visitante = new Visitante();

	@ManyToOne
	private Cela cela = new Cela();

	// constr
	public Historico(Regime regime, String descricao, Reeducando reeducando,
			Date dtHistorico, Cela cela) {
		super();
		this.regime = regime;
		this.descricao = descricao;
		this.reeducando = reeducando;
		this.dtHistorico = dtHistorico;
		this.cela = cela;
	}

	public Historico() {
		// TODO Auto-generated constructor stub

	}

	public Reeducando getReeducando() {
		return reeducando;
	}

	public void setReeducando(Reeducando reeducando) {
		this.reeducando = reeducando;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Regime getRegime() {
		return regime;
	}

	public void setRegime(Regime regime) {
		this.regime = regime;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDtHistorico() {
		return dtHistorico;
	}

	public void setDtHistorico(Date dtHistorico) {
		this.dtHistorico = dtHistorico;
	}

	public Cela getCela() {
		return cela;
	}

	public void setCela(Cela cela) {
		this.cela = cela;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}


}
