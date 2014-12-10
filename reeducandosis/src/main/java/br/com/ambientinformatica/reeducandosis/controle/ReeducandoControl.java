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
import br.com.ambientinformatica.reeducandosis.entidade.Historico;
import br.com.ambientinformatica.reeducandosis.entidade.Reeducando;
import br.com.ambientinformatica.reeducandosis.entidade.Regime;
import br.com.ambientinformatica.reeducandosis.persistencia.AlcunhaDao;
import br.com.ambientinformatica.reeducandosis.persistencia.CelaDao;
import br.com.ambientinformatica.reeducandosis.persistencia.EnderecoDao;
import br.com.ambientinformatica.reeducandosis.persistencia.HistoricoDao;
import br.com.ambientinformatica.reeducandosis.persistencia.ReeducandoDao;

@Controller("ReeducandoControl")
@Scope("conversation")
public class ReeducandoControl {

	private Reeducando reeducando = new Reeducando();
	private Reeducando newreeducando = new Reeducando();
	private List<Reeducando> reeducandos = new ArrayList<Reeducando>();
	private List<Historico> historicos = new ArrayList<Historico>();
	private Historico historico = new Historico();
	private Date date = new Date(System.currentTimeMillis());// ////////////////////////////////////////////////////Informar
																// a data de
																// Hoje
																// !!!!!!!!!
	@Autowired
	private ReeducandoDao reeducandodao;
	@Autowired
	private AlcunhaDao alcunhadao;
	@Autowired
	private EnderecoDao enderecodao;
	@Autowired
	private HistoricoDao historicodao;
	@Autowired
	private CelaDao celadao;

	// AVANÇARPAGINA
	private boolean skip;

	@PostConstruct
	public void init() {
		listar(null);
	}

	// MANTER REEDUCANDO
	public void confirmar(ActionEvent evt) {
		try {
			alcunhadao.incluir(newreeducando.getAlcunha());
			enderecodao.incluir(newreeducando.getEndereco());
			reeducandodao.incluir(newreeducando);
			celadao.incluir(historico.getCela());
			historicodao.incluir(novoHistorico());
			newreeducando = new Reeducando();
			historico = new Historico();
			listar(evt);
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	public void listar(ActionEvent evt) {
		try {
			reeducandos = reeducandodao.listar();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	// MONTA UM HISTORICO PRA INCLUIR
	private Historico novoHistorico() {
		historico.setVisitante(null);
		historico.setReeducando(newreeducando);
		historico.setDtHistorico(date);
		return historico;
	}

	// HISTORICO DO REEDUCANDO
	public String contruirlistareeducando() {
		historicos = ListarHistoricobyReeducando(reeducando.getId());
		return "reeducandohistorico";
	}


	// BUSCAR HISOTORICO POR REEDUCANDO
	public List<Historico> ListarHistoricobyReeducando(int id) {
		List<Historico> historicos;// = new ArrayList<Historico>();
		List<Historico> historicosFinal = new ArrayList<Historico>();
		try {
			historicos = historicodao.listar();
			for (int i = 0; i < historicos.size(); i++) {
				if (!(historicos.get(i).getReeducando() == null)) {
					if (historicos.get(i).getReeducando().getId() == id) {
						historicosFinal.add(historicos.get(i));
					}
				}
			}

		} catch (Exception e) {
			UtilFaces.addMensagemFaces("Este Reeducando não Possui Histórico");
		}
		return historicosFinal;
	}
	//INCLUIR HISTORICO DO REEDUCANDO POS
	public void incluirHistorico() {
		try {
			celadao.incluir(historico.getCela());
			historico.setVisitante(null);
			historico.setReeducando(reeducando);
			historico.setDtHistorico(date);
			historicodao.incluir(historico);
			historico = new Historico();
			contruirlistareeducando();
		} catch (Exception e) {
			UtilFaces.addMensagemFaces(e);
		}
	}

	//CANCELAR CADASTRO DE VISITANTE
	public void Cancelar(){
		newreeducando = new Reeducando();		
	}
	
	public void CancelarUpdate(){
		reeducando = new Reeducando();
	}
	
	public String LimparCamposReeducando(){
		newreeducando = new Reeducando();
		historico = new Historico();
		return "reeducando";		
	}
	
	
	// HISTORICO DO REEDUCANDO
	public void AtualizarDados() {
		try {
		enderecodao.alterar(reeducando.getEndereco());
		alcunhadao.alterar(reeducando.getAlcunha());
		reeducandodao.alterar(reeducando);
		reeducando = new Reeducando();
		listar(null);
	} catch (Exception e) {
		UtilFaces.addMensagemFaces(e);
	}
}
	
	
	// GTT E STT

	// PEGA AS POSICAO DA CLASSE ENUN
	public Regime[] getRegimes() {
		return Regime.values();
	}

	public Reeducando getReeducando() {
		return reeducando;
	}

	public void setReeducando(Reeducando reeducando) {
		this.reeducando = reeducando;
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

	public boolean isSkip() {
		return skip;
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

	public List<Historico> getHistoricos() {
		return historicos;
	}

	public void setHistoricos(List<Historico> historicos) {
		this.historicos = historicos;
	}

	public Reeducando getNewreeducando() {
		return newreeducando;
	}

	public void setNewreeducando(Reeducando newreeducando) {
		this.newreeducando = newreeducando;
	}

	
}
