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

import sgcf.persistencia.dao.EventoDAO;
import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.entidade.Evento;
import sgcf.persistencia.entidade.Funcionario;


@ManagedBean(name="eventoManagerBean")
@RequestScoped
public class EventoManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1830236823116761167L;
	private EventoDAO eventoDAO = new EventoDAO();
	private Evento evento = new Evento();
	private DataModel listaEventos;

	public EventoManagerBean(){
		
	}
	
	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public DataModel getListaEventos() {
		EventoDAO eventoDAO = new EventoDAO();
		List<Evento> lista = eventoDAO.getLista();
		listaEventos = new ListDataModel(lista);
		return listaEventos;
	}

	public void setListaEventos(DataModel listaEventos) {
		this.listaEventos = listaEventos;
	}
	
	public List<Funcionario> getListaFuncionarios(){
		return new FuncionarioDAO().getLista();
	}
	
	public boolean tratarSalvamento(){
		boolean continua = true;
		if(evento.getNome() == null || evento.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o nome: obrigatorio!"));
			continua = false;
		}else{
			List<Evento> eventos = new ArrayList<Evento>();
			eventos = eventoDAO.getLista();
			
			for (Evento itemLista : eventos) {
				
				if( itemLista.getNome().equals(evento.getNome()) ){
					if( evento.getId() == null || (evento.getId() != null && !itemLista.getId().equals(evento.getId()))  ){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Evento já existe!"));
						return false;
					}
				}
				
			}
		}
		return continua;
	}
	

	public void salvarEvento(){
		if(tratarSalvamento()){
			if(evento.getId() == null){
				try {
					eventoDAO.cadastrar(evento);
					evento = new Evento();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}else{
				try {
					eventoDAO.alterar(evento);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
	
	}
	
	public void excluirEvento(){
		if(evento.getId() != null){
			System.out.println(evento.getId().toString());
			try {
				evento = eventoDAO.getPorId(evento.getId());
				if(eventoDAO.excluir(evento)){
					evento = new Evento();
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
		evento = new Evento();
	}
	
	public String prepararAdicionarEvento(){
		limpar();
		return "gerenciarevento";
	}
	
	
	public void prepararAlterarEvento(){
		evento = (Evento)listaEventos.getRowData();
	}

	
}
