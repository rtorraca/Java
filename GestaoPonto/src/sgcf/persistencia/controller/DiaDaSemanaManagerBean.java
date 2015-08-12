package sgcf.persistencia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import sgcf.persistencia.dao.DiaDaSemanaDAO;
import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.dao.MarcacaoDAO;
import sgcf.persistencia.dao.TipoDiaDAO;
import sgcf.persistencia.dao.TurnoDAO;
import sgcf.persistencia.entidade.DiaDaSemana;
import sgcf.persistencia.entidade.Funcionario;
import sgcf.persistencia.entidade.Marcacao;
import sgcf.persistencia.entidade.TipoDia;
import sgcf.persistencia.entidade.Turno;

@ManagedBean(name="diaDaSemanaManagerBean")
@RequestScoped
public class DiaDaSemanaManagerBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6103583105702574218L;
	private DiaDaSemanaDAO diaDaSemanaDAO = new DiaDaSemanaDAO();
	private DiaDaSemana diaDaSemana = new DiaDaSemana();
	private DataModel listaDiaDaSemanas;
	private DataModel listaMarcacoes;

	public DiaDaSemanaManagerBean(){
		System.out.println("Construtor de DiaDaSemanaManagerBean");
		diaDaSemana = new DiaDaSemana();
		diaDaSemana.setTurno(new Turno());
		diaDaSemana.setTipodia(new TipoDia());
		diaDaSemana.setNome("");
		diaDaSemana.setJornada(0.0);
	}
	
	public DiaDaSemana getDiaDaSemana() {
		return diaDaSemana;
	}

	public void setDiaDaSemana(DiaDaSemana diaDaSemana) {
		this.diaDaSemana = diaDaSemana;
	}

	public DataModel getListaDiaDaSemanas() {
		DiaDaSemanaDAO diaDaSemanaDAO = new DiaDaSemanaDAO();
		List<DiaDaSemana> lista = new ArrayList<DiaDaSemana>();
		if(diaDaSemana.getTurno() == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecione o turno"));
		}else{
			diaDaSemanaDAO.getListaPorTurno(diaDaSemana.getTurno());
		}
		listaDiaDaSemanas = new ListDataModel(lista);
		return listaDiaDaSemanas;
	}

	public DataModel getListaMarcacoes(){
		List<Marcacao> marcacoes = new ArrayList<Marcacao>();
		if(diaDaSemana.getId() == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecione o dia"));
		}else{
			marcacoes = new MarcacaoDAO().getListaPorDiaDaSemana(diaDaSemana);
			listaMarcacoes = new ListDataModel(marcacoes);
		}
		return listaMarcacoes;
	}
	public List<TipoDia> getListaTipoDias(){
		return new TipoDiaDAO().getLista();
	}
	
	public List<Turno> getListaTurnos(){
		return new TurnoDAO().getLista();
	}
	
	public void setListaDiaDaSemanas(DataModel listaDiaDaSemanas) {
		this.listaDiaDaSemanas = listaDiaDaSemanas;
	}
	
	public List<Funcionario> getListaFuncionarios(){
		return new FuncionarioDAO().getLista();
	}
	
	public boolean tratarSalvamento(){
		boolean continua = true;
		if(diaDaSemana.getNome() == null || diaDaSemana.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o nome: obrigatorio!"));
			continua = false;
		}else if(diaDaSemana.getTipodia() == null ){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o tipo do dia: obrigatorio!"));
			continua = false;
		}else if(diaDaSemana.getJornada() == null ){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com a jornada: obrigatorio!"));
			continua = false;
		}else{
			List<DiaDaSemana> diaDaSemanas = new ArrayList<DiaDaSemana>();
			diaDaSemanas = diaDaSemanaDAO.getListaPorTurno(diaDaSemana.getTurno());
			
			for (DiaDaSemana itemLista : diaDaSemanas) {
				
				if( itemLista.getNome().equals(diaDaSemana.getNome()) ){
					if( diaDaSemana.getId() == null || (diaDaSemana.getId() != null && !itemLista.getId().equals(diaDaSemana.getId()))  ){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Dia da semana já existe!"));
						return false;
					}
				}
				
			}
		}
		return continua;
	}
	

	public void salvarDiaDaSemana(){
		if(tratarSalvamento()){
			if(diaDaSemana.getId() == null){
				try {
					diaDaSemanaDAO.cadastrar(diaDaSemana);
					this.limpar();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}else{
				try {
					diaDaSemanaDAO.alterar(diaDaSemana);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
	
	}
	
	public void excluirDiaDaSemana(){
		if(diaDaSemana.getId() != null){
			System.out.println(diaDaSemana.getId().toString());
			try {
				diaDaSemana = diaDaSemanaDAO.getPorId(diaDaSemana.getId());
				if(diaDaSemanaDAO.excluir(diaDaSemana)){
					diaDaSemana = new DiaDaSemana();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deletado com sucesso!"));
				}else{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nao pode ser deletado!"));
				}
			
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			}
			
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Para deletar o registro é necessario ter carregado os dados no formulario!"));
		}
	}
	
	public void limpar(){
		Turno turno = diaDaSemana.getTurno();
		diaDaSemana = new DiaDaSemana();
		diaDaSemana.setTurno(turno);
	}
	
	public String prepararAdicionarDiaDaSemana(){
		limpar();
		return "gerenciardiaDaSemana";
	}
	
	
	public void prepararAlterarDiaDaSemana(){
		diaDaSemana = (DiaDaSemana)listaDiaDaSemanas.getRowData();
	}

}
