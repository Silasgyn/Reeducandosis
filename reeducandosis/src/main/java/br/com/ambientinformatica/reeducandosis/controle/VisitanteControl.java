package br.com.ambientinformatica.reeducandosis.controle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
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
import br.com.ambientinformatica.reeducandosis.persistencia.EnderecoDao;
import br.com.ambientinformatica.reeducandosis.persistencia.HistoricoDao;
import br.com.ambientinformatica.reeducandosis.persistencia.ReeducandoDao;
import br.com.ambientinformatica.reeducandosis.persistencia.VisitanteDao;

@Controller("VisitanteControl")
@Scope("conversation")
public class VisitanteControl {
	private Visitante newvisitante = new Visitante();
	private Visitante visitante = new Visitante();
	private Reeducando reedNome = new Reeducando();
	private List<Visitante> visitantes = new ArrayList<Visitante>();
	private List<Reeducando> reeducandos = new ArrayList<Reeducando>();
	private Historico historico = new Historico();
	private List<Historico> historicos = new ArrayList<Historico>();
	private Date date = new Date(System.currentTimeMillis());// ////////////////////////////////////////////////////Informar
																// a data de
																// Hoje
																// !!!!!!!!!
	@Autowired
	private VisitanteDao visitantedao;
	@Autowired
	private EnderecoDao enderecodao;
	@Autowired
	private HistoricoControl historicoControl;
	@Autowired
	private HistoricoDao historicodao;

	@Autowired
	private ReeducandoDao reeducandodao;

	// AVANÇARPAGINA
	private boolean skip;

	@PostConstruct
	public void init() {
		listar(null);
	}

	// -- NOVO VISITANTE
	// LISTAR VISITANTES
	public void listar(ActionEvent evt) {
		try {
			visitantes = visitantedao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	// INCLUIR VISITANTES
	public void Confirmar(ActionEvent evt) {
		try {
			enderecodao.incluir(newvisitante.getEndereco());
			visitantedao.incluir(newvisitante);
			historicodao.incluir(novoHistorico());
			newvisitante = new Visitante();
			historico = new Historico();
			listar(evt);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	// INCLUIR HISTORICO INICIAL
	private Historico novoHistorico() {
		historico.setDescricao("CADASTRO DO VISITANTE");
		historico.setDtHistorico(date);
		historico.setVisitante(newvisitante);
		historico.setReeducando(null);
		historico.setCela(null);
		return historico;
	}

	// CANCELAR CADASTRO DE VISITANTE
	public void Cancelar() {
		newvisitante = new Visitante();
	}

	public void CancelarUpdate() {
		visitante = new Visitante();

	}

	public String LimparCamposVisitante() {
		newvisitante = new Visitante();
		return "visitante";
	}

	// ATUALIZAR DADOS VISITANTE
	public void AtualizarDados(ActionEvent evt) {
		try {
			enderecodao.alterar(visitante.getEndereco());
			visitantedao.alterar(visitante);
			visitante = new Visitante();
			listar(null);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	// -------

	// VISITA AO REEDUCANDO - INCLUIR HISTORICO

	public String construirLista() {
		historicos = historicoControl.ListarHistoricobyVisitante(visitante
				.getId());
		return "visitantehistorico";
	}

	public String abrirUpateVisitante() {
		return "visitanteupdate";
	}

	public void incluirHistorico() {
		try {
			historico.setCela(null);
			historico.setVisitante(visitante);
			historico.setReeducando(reedNome);
			historico.setDtHistorico(date);
			historicodao.incluir(historico);
			historico = new Historico();
			construirLista();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	// MET. PARA BUSCAR REEDUCANDO AUTOCOMPLETE
	public List<Reeducando> completaReeducando(String nome)
			throws PersistenciaException {

		List<Reeducando> allReed = reeducandodao.listar();
		List<Reeducando> filteredReed = new ArrayList<Reeducando>();

		for (int i = 0; i < allReed.size(); i++) {
			Reeducando reed = allReed.get(i);
			if (reed.getNome().toLowerCase().startsWith(nome)) {
				filteredReed.add(reed);
			}
		}

		return filteredReed;

	}

	// GET SET

	public boolean isSkip() {
		return skip;
	}

	public Visitante getVisitante() {
		return visitante;
	}

	public void setVisitante(Visitante visitante) {
		this.visitante = visitante;
	}

	public Reeducando getReeducando() {
		return reedNome;
	}

	public void setReeducando(Reeducando reeducando) {
		this.reedNome = reeducando;
	}

	public List<Visitante> getVisitantes() {
		return visitantes;
	}

	public void setVisitantes(List<Visitante> visitantes) {
		this.visitantes = visitantes;
	}

	public List<Reeducando> getReeducandos() {
		return reeducandos;
	}

	public void setReeducandos(List<Reeducando> reeducandos) {
		this.reeducandos = reeducandos;
	}

	public Historico getHistorico() {
		return historico;
	}

	public void setHistorico(Historico historico) {
		this.historico = historico;
	}

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public VisitanteDao getVisitantedao() {
		return visitantedao;
	}

	public void setVisitantedao(VisitanteDao visitantedao) {
		this.visitantedao = visitantedao;
	}

	public EnderecoDao getEnderecodao() {
		return enderecodao;
	}

	public void setEnderecodao(EnderecoDao enderecodao) {
		this.enderecodao = enderecodao;
	}

	public HistoricoControl getHistoricoControl() {
		return historicoControl;
	}

	public void setHistoricoControl(HistoricoControl historicoControl) {
		this.historicoControl = historicoControl;
	}

	public HistoricoDao getHistoricodao() {
		return historicodao;
	}

	public void setHistoricodao(HistoricoDao historicodao) {
		this.historicodao = historicodao;
	}

	public ReeducandoDao getReeducandodao() {
		return reeducandodao;
	}

	public void setReeducandodao(ReeducandoDao reeducandodao) {
		this.reeducandodao = reeducandodao;
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

	public Reeducando getReedNome() {
		return reedNome;
	}

	public void setReedNome(Reeducando reedNome) {
		this.reedNome = reedNome;
	}

	public Visitante getNewvisitante() {
		return newvisitante;
	}

	public void setNewvisitante(Visitante newvisitante) {
		this.newvisitante = newvisitante;
	}

}
