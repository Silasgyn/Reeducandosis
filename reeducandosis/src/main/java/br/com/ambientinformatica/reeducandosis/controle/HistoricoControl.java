package br.com.ambientinformatica.reeducandosis.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import javax.faces.event.ActionEvent;

import org.primefaces.event.FlowEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.ambientinformatica.ambientjsf.util.UtilFaces;
import br.com.ambientinformatica.jpa.exception.PersistenciaException;
import br.com.ambientinformatica.reeducandosis.entidade.Historico;
import br.com.ambientinformatica.reeducandosis.entidade.Reeducando;
import br.com.ambientinformatica.reeducandosis.entidade.Visitante;
import br.com.ambientinformatica.reeducandosis.persistencia.CelaDao;
import br.com.ambientinformatica.reeducandosis.persistencia.HistoricoDao;
import br.com.ambientinformatica.reeducandosis.persistencia.ReeducandoDao;
import br.com.ambientinformatica.reeducandosis.persistencia.VisitanteDao;

@Controller("HistoricoControl")
@Scope("conversation")
public class HistoricoControl {
	
	@Autowired
	private HistoricoDao historicodao;
	@Autowired
	private CelaDao celadao;
	@Autowired
	private ReeducandoDao reeducandodao;
	@Autowired
	private VisitanteDao visitantedao;

	private Historico historico = new Historico();
	private Reeducando reeducando = new Reeducando();
	private Visitante visitante = new Visitante();
	private List<Visitante> visitantes = new ArrayList<Visitante>();
	private List<Reeducando> reeducandos = new ArrayList<Reeducando>();

	private List<Historico> historicos;
	private Date date = new Date(System.currentTimeMillis());// Informar a data
																// de Hoje!
	private boolean skip;
	private int visitaid;

	public HistoricoControl() {
		super();
	}


	// Metodo de Busca de Historico por Visitante
	public List<Historico> ListarHistoricobyVisitante(int id) {
		// HistoricoDaoJpa historicoDaoJpa = new HistoricoDaoJpa();
		List<Historico> historicos;// = new ArrayList<Historico>();
		List<Historico> historicosFinal = new ArrayList<Historico>();
		try {
			historicos = historicodao.listar();
			for (int i = 0; i < historicos.size(); i++) {
				if (!(historicos.get(i).getVisitante() ==  null)) {
					if (historicos.get(i).getVisitante().getId() == id) {
						historicosFinal.add(historicos.get(i));
					}
				}
			}

		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Este Visitante não Possui Histórico");
		}
		return historicosFinal;

	}

	// CONFIRMAR PRA INCLUIR
	public void confirmar(ActionEvent evt) {
		try {
			incluirListar(historico);
			historico = new Historico();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	// NAOUTILIZADO
	public List<Historico> incluirListar(Historico historico) {
		List<Historico> list = new ArrayList<Historico>();
		try {
			celadao.incluir(historico.getCela());
			historico.setReeducando(reeducando);
			historico.setDtHistorico(date);
			historicodao.incluir(historico);
			list = historicodao.listar();
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}

	// NAOUSADO
	public void incluir() {
		try {
			celadao.incluir(historico.getCela());
			historicodao.incluir(historico);
		} catch (PersistenciaException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void listarReeducando(ActionEvent evt) {
		try {
			reeducandos = reeducandodao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listarHistorico(ActionEvent evt) {
		try {
			historicos = historicodao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public Reeducando getReeducando() {
		return reeducando;
	}

	// MONTA UM HISTORICO PRA INCLUIR
	private Historico novoHistorico() {
		this.setReeducando(reeducando);
		this.getHistorico().setDtHistorico(date);
		return this.getHistorico();
	}

	// GTT E STT
	public void setReeducando(Reeducando reeducando) {
		this.reeducando = reeducando;
	}

	public List<Historico> getReeducandos() {
		return historicos;
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public boolean isSkip() {
		return skip;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public void setReeducandos(List<Reeducando> reeducandos) {
		this.reeducandos = reeducandos;
	}

	public void setSkip(boolean skip) {
		this.skip = skip;
	}

	public String onFlowProcess(FlowEvent event) {
		if (skip) {
			skip = false; // reset in case user goes back
			return "confirm";
		} else {
			return event.getNewStep();
		}
	}

	public int getVisitaid() {
		return visitaid;
	}

	public void setVisitaid(int visitaid) {
		this.visitaid = visitaid;
	}

	public List<Visitante> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(List<Visitante> visitantes) {
		this.visitantes = visitantes;
	}


}
