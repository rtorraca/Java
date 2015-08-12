package sgcf.persistencia.controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.dao.LicencaDAO;
import sgcf.persistencia.dao.TipoLicencaDAO;
import sgcf.persistencia.entidade.Funcionario;
import sgcf.persistencia.entidade.Licenca;
import sgcf.persistencia.entidade.Licenca;
import sgcf.persistencia.entidade.TipoLicenca;

@ManagedBean(name="licencaManagerBean")
@RequestScoped
public class LicencaManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2578374930301642215L;
	private Licenca licenca = new Licenca();
	private DataModel listaLicencas;
	private LicencaDAO licencaDAO = new LicencaDAO();
	
	
	public LicencaManagerBean(){
		System.out.println("Construtor de LicencaManagerBean");

		this.limpar();
	}
	
	public Licenca getLicenca() {
		return licenca;
	}

	public void setLicenca(Licenca licenca) {
		this.licenca = licenca;
	}

	public DataModel getListaLicencas() {
		LicencaDAO licencaDAO = new LicencaDAO();
		List<Licenca> lista = licencaDAO.getLista();
		listaLicencas = new ListDataModel(lista);
		return listaLicencas;
	}

	public void setListaLicencas(DataModel listaLicencas) {
		this.listaLicencas = listaLicencas;
	}
	
	public List<TipoLicenca> getListaTipoLicencas(){
		return new TipoLicencaDAO().getLista();
	}
	
	public List<Funcionario> getListaFuncionarios(){
		return new FuncionarioDAO().getLista();
	}

	
	public boolean tratarSalvamento(){
		boolean continua = true;
	
		if(licenca.getData_ini() == null ){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o data de início: obrigatorio!"));
			continua = false;
		}else if(licenca.getData_fim() == null ){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o data de fim: obrigatorio!"));
			continua = false;
		}else if(licenca.getTipolicenca().getNome().equals("maternidade")){
			long diferenca = 0;
			int tempoDia  = 1000 * 60 * 60 * 24;
			long diasDiferenca = 0;
			diferenca = licenca.getData_fim().getTime()-licenca.getData_ini().getTime();
			diferenca += tempoDia;
			diasDiferenca = diferenca/tempoDia;
			System.out.println(diasDiferenca);
			
			if( diasDiferenca != 120){
				int dias = (120 - (int)diasDiferenca);
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O número de dias da licenca de maternidade não é 120 faltam:"+dias));
				continua = false;
			}
		}
		return continua;
	}
	public String salvarLicenca(){
		if(tratarSalvamento()){
			if(licenca.getId() == null){
				
				try {
					licencaDAO.cadastrar(licenca);
					licenca = new Licenca();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
				
			}else{
				try {
					licencaDAO.alterar(licenca);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
		
		return "gerenciarlicencas";
	}
	

	
	public void excluirLicenca(){
		if(licenca.getId() != null){
			
			try {
				licenca = licencaDAO.getPorId(licenca.getId());
				if(licencaDAO.excluir(licenca)){
					licenca = new Licenca();
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
		licenca = new Licenca();
		licenca.setFuncionario(new Funcionario());
		licenca.getFuncionario().setNome("");
	}
	
	public String prepararAdicionarLicenca(){
		limpar();
		return "gerenciarlicencas";
	}
	
	
	public void prepararAlterarLicenca(){
		licenca = (Licenca)listaLicencas.getRowData();
	}
	

}
