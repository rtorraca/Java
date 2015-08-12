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
import javax.inject.Inject;
import sgcf.persistencia.dao.ParcelaDAO;
import sgcf.persistencia.entidade.Ferias;
import sgcf.persistencia.entidade.Parcela;
import sgcf.persistencia.entidade.Parcela;

@ManagedBean(name="parcelaManagerBean")
@RequestScoped
public class ParcelaManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6403738983525459675L;
	private Parcela parcela = new Parcela();
	private DataModel listaParcelas;
	private ParcelaDAO parcelaDAO = new ParcelaDAO();
	
	public ParcelaManagerBean() {
		System.out.println("Construtor de ParcelaManagerBean");
		parcela = new Parcela();
	}
	
	public Parcela getParcela() {
		return parcela;
	}

	public void setParcela(Parcela parcela) {
		this.parcela = parcela;
	}

	public DataModel getListaParcelas() {
		ParcelaDAO parcelaDAO = new ParcelaDAO();
		List<Parcela> lista = parcelaDAO.getListaPorFerias(parcela.getFerias());
		listaParcelas = new ListDataModel(lista);
		return listaParcelas;
	}
	
	public void setListaParcelas(DataModel listaParcelas) {
		this.listaParcelas = listaParcelas;
	}
	
	public boolean tratarSalvamento(){

		boolean continua = true;
		
		if(parcela.getData_ini().compareTo(parcela.getData_fim()) > 0){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A data de início é maior que a data de fim"));
			return false;
		}
		
		
		long diferenca = 0;
		int tempoDia  = 1000 * 60 * 60 * 24;
		long diasDiferenca = 0;
		long diasDiferencaTotal = 0;
		
		
		
		List<Parcela> lista = new ArrayList<Parcela>();
		lista = parcelaDAO.getListaPorFerias(parcela.getFerias());
		long total = 0;
		int numParcelas = 0;
		diferenca = parcela.getData_fim().getTime()-parcela.getData_ini().getTime();
		diferenca += tempoDia;
		diasDiferenca = diferenca/tempoDia;
		total += diferenca;
		System.out.println("diasDiferenca:"+diasDiferenca);
		if(!lista.isEmpty()){
			for (Parcela parcela1 : lista) {
				if( parcela.getData_ini().compareTo(parcela1.getData_fim()) <= 0 ){
					if(parcela.getId() == null || (parcela.getId() != null && !parcela.getId().equals(parcela1.getId()))){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A parcela está contida em outra que já existe"));
						return false;
					}
				}
				else if ( parcela.getId() == null || (parcela.getId() != null && !parcela.getId().equals(parcela1.getId()))) {
					diferenca = parcela1.getData_fim().getTime()-parcela1.getData_ini().getTime();
					total += diferenca + tempoDia;
				}
			
			}
			numParcelas = lista.size();
		}
		diasDiferencaTotal = total/tempoDia;
		System.out.println("diasDiferencaTotal:"+diasDiferencaTotal);
		
		if(parcela.getData_ini() == null ){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o data de início: obrigatorio!"));
			continua = false;
		}else if(parcela.getData_fim() == null ){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o data de fim: obrigatorio!"));
			continua = false;
		}else if(numParcelas == 3){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Excedeu o numero de parcelas"));
			continua = false;
		}else if(diasDiferencaTotal > parcela.getFerias().getDias_gozados()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O soma de dias das parcelas ultrapassou o numero de dias gozados: "+diasDiferencaTotal));
			continua = false;
		}else if(diasDiferenca < 5){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O numero de dias da parcela é menor que o limite permitido: "+diasDiferenca));
			continua = false;
		}else if(numParcelas == 2 && ((parcela.getFerias().getDias_gozados() - diasDiferencaTotal) > 0) ){
			long dias = parcela.getFerias().getDias_gozados() - diasDiferencaTotal;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aumente o número de dias da parcela para "+dias));
			continua = false;
		}else if( (parcela.getFerias().getDias_gozados() - diasDiferencaTotal) < 5 && (parcela.getFerias().getDias_gozados() - diasDiferencaTotal) > 0){
			long dias = parcela.getFerias().getDias_gozados() - diasDiferencaTotal;
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Aumente o número de dias da parcela para "+dias));
			continua = false;
		}
		
		return continua;
	}
	
	public void salvarParcela(){
		if(tratarSalvamento()){
			if(parcela.getId() == null){
			
				try {
					parcelaDAO.cadastrar(parcela);
					Ferias ferias = parcela.getFerias();
					parcela = new Parcela();
					parcela.setFerias(ferias);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
				
			}else{
				try {
					parcelaDAO.alterar(parcela);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
	}
	
	
	public void excluirParcela(){
		if(parcela.getId() != null){
		
			try {
				parcela = parcelaDAO.getPorId(parcela.getId());
				if(parcelaDAO.excluir(parcela)){
					Ferias ferias = parcela.getFerias();
					parcela = new Parcela();
					parcela.setFerias(ferias);
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
		Ferias ferias = parcela.getFerias();
		parcela = new Parcela();
		parcela.setFerias(ferias);
	}
	


}
