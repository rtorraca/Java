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

import sgcf.persistencia.dao.LicencaDAO;
import sgcf.persistencia.dao.TipoLicencaDAO;
import sgcf.persistencia.entidade.Licenca;
import sgcf.persistencia.entidade.TipoLicenca;

@ManagedBean(name="tipoLicencaManagerBean")
@RequestScoped
public class TipoLicencaManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1187036893425136254L;
	private TipoLicenca tipoLicenca = new TipoLicenca();
	private DataModel listaTipoLicencas;
	private TipoLicencaDAO tipoLicencaDAO = new TipoLicencaDAO();
	
	public TipoLicenca getTipoLicenca() {
		return tipoLicenca;
	}

	public void setTipoLicenca(TipoLicenca tipoLicenca) {
		this.tipoLicenca = tipoLicenca;
	}

	public DataModel getListaTipoLicencas() {
		TipoLicencaDAO tipoLicencaDAO = new TipoLicencaDAO();
		List<TipoLicenca> lista = tipoLicencaDAO.getLista();
		listaTipoLicencas = new ListDataModel(lista);
		return listaTipoLicencas;
	}

	public void setListaTipoLicencas(DataModel listaTipoLicencas) {
		this.listaTipoLicencas = listaTipoLicencas;
	}

	public List<Licenca> getListaLicencas() {
		return new LicencaDAO().getLista();
	}
	
	public boolean tratarSalvamento(){
		boolean continua = true;
		if(tipoLicenca.getNome() == null || tipoLicenca.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o nome: obrigatorio!"));
			continua = false;
		}else{
			List<TipoLicenca> tipoLicencas = new ArrayList<TipoLicenca>();
			tipoLicencas = tipoLicencaDAO.getLista();
			
			for (TipoLicenca itemLista : tipoLicencas) {
				if( itemLista.getNome().equals(tipoLicenca.getNome()) ){
					if(tipoLicenca.getId() == null || (tipoLicenca.getId() != null && !tipoLicenca.getId().equals(itemLista.getId())) ){ 
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Tipo de licença já existe!"));
						return false;
					}
				}
			}
		}
		return continua;
	}
	
	public void salvarTipoLicenca(){
		if(tratarSalvamento()){
			if(tipoLicenca.getId() == null){
				
				try {
					tipoLicencaDAO.cadastrar(tipoLicenca);
					tipoLicenca = new TipoLicenca();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			
			}else{
				try {
					tipoLicencaDAO.alterar(tipoLicenca);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
	}
	
	
	
	public void excluirTipoLicenca(){
		if(tipoLicenca.getId() != null){
			
			try {
				tipoLicenca = tipoLicencaDAO.getPorId(tipoLicenca.getId());
				if(tipoLicencaDAO.excluir(tipoLicenca)){
					tipoLicenca = new TipoLicenca();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deletado com sucesso!"));
				}else{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não pode ser deletado!"));
				}
			} catch (Exception e) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
			}
		
		
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Para deletar o registro é necessario ter carregado os dados no formulario!"));
		}
	}
	
	public void limpar(){
		tipoLicenca = new TipoLicenca();
	}
	
	public String prepararAdicionarTipoLicenca(){
		limpar();
		return "gerenciartipolicencas";
	}
	
	
	public void prepararAlterarTipoLicenca(){
		tipoLicenca = (TipoLicenca)listaTipoLicencas.getRowData();
	}
}
