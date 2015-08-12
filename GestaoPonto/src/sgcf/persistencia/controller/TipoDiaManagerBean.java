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

import sgcf.persistencia.dao.TipoDiaDAO;
import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.entidade.TipoDia;
import sgcf.persistencia.entidade.Funcionario;

@ManagedBean(name="tipoDiaManagerBean")
@RequestScoped
public class TipoDiaManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -283101124584202L;
	private TipoDiaDAO tipoDiaDAO = new TipoDiaDAO();
	private TipoDia tipoDia = new TipoDia();
	private DataModel listaTipoDias;

	public TipoDiaManagerBean(){
		
	}
	
	public TipoDia getTipoDia() {
		return tipoDia;
	}

	public void setTipoDia(TipoDia tipoDia) {
		this.tipoDia = tipoDia;
	}

	public DataModel getListaTipoDias() {
		TipoDiaDAO tipoDiaDAO = new TipoDiaDAO();
		List<TipoDia> lista = tipoDiaDAO.getLista();
		listaTipoDias = new ListDataModel(lista);
		return listaTipoDias;
	}
	


	public void setListaTipoDias(DataModel listaTipoDias) {
		this.listaTipoDias = listaTipoDias;
	}
	
	public List<Funcionario> getListaFuncionarios(){
		return new FuncionarioDAO().getLista();
	}
	
	public boolean tratarSalvamento(){
		boolean continua = true;
		if(tipoDia.getNome() == null || tipoDia.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o nome: obrigatorio!"));
			continua = false;
		}else{
			List<TipoDia> tipoDias = new ArrayList<TipoDia>();
			tipoDias = tipoDiaDAO.getLista();
			
			for (TipoDia itemLista : tipoDias) {
				
				if( itemLista.getNome().equals(tipoDia.getNome()) ){
					if( tipoDia.getId() == null || (tipoDia.getId() != null && !itemLista.getId().equals(tipoDia.getId()))  ){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("TipoDia já existe!"));
						return false;
					}
				}
				
			}
		}
		return continua;
	}
	

	public void salvarTipoDia(){
		if(tratarSalvamento()){
			if(tipoDia.getId() == null){
				try {
					tipoDiaDAO.cadastrar(tipoDia);
					tipoDia = new TipoDia();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}else{
				try {
					tipoDiaDAO.alterar(tipoDia);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
	
	}
	
	public void excluirTipoDia(){
		if(tipoDia.getId() != null){
			System.out.println(tipoDia.getId().toString());
			try {
				tipoDia = tipoDiaDAO.getPorId(tipoDia.getId());
				if(tipoDiaDAO.excluir(tipoDia)){
					tipoDia = new TipoDia();
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
		tipoDia = new TipoDia();
	}
	
	public String prepararAdicionarTipoDia(){
		limpar();
		return "gerenciartipodia";
	}
	
	
	public void prepararAlterarTipoDia(){
		tipoDia = (TipoDia)listaTipoDias.getRowData();
	}
	
}
