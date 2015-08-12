package sgcf.persistencia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import sgcf.persistencia.dao.FeriasDAO;
import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.dao.ParcelaDAO;
import sgcf.persistencia.entidade.Ferias;
import sgcf.persistencia.entidade.Ferias;
import sgcf.persistencia.entidade.Funcionario;
import sgcf.persistencia.entidade.Parcela;

@ManagedBean(name="feriasManagerBean")
@RequestScoped
public class FeriasManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -434137964566972928L;
	protected Ferias ferias = new Ferias();
	protected DataModel listaFerias;
	protected DataModel listaParcelas;

	private FeriasDAO feriasDAO = new FeriasDAO();
	
	
	public FeriasManagerBean(){
		System.out.println("Construtor de FeriasManagerBean");

		this.limpar();
		
	}
	
	public Ferias getFerias() {
		return ferias;
	}

	public void setFerias(Ferias ferias) {
		this.ferias = ferias;
	}

	public DataModel getListaFerias() {
		FeriasDAO feriasDAO = new FeriasDAO();
		List<Ferias> lista = feriasDAO.getLista();
		listaFerias = new ListDataModel(lista);
		return listaFerias;
	}

	public void setListaFerias(DataModel listaFerias) {
		this.listaFerias = listaFerias;
	}
	
	public DataModel getListaParcelas(){
		ParcelaDAO parcelaDAO = new ParcelaDAO();
		if(ferias.getId() != null){
			List<Parcela> lista = parcelaDAO.getListaPorFerias(ferias);
			listaParcelas = new ListDataModel(lista);
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecione as ferias"));
		}
		return listaParcelas;
	}
	

	public boolean tratarSalvamento(){
		boolean continua = true;
		
		
		if(ferias.getDias_gozados() == null ){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o número de dias gozados: obrigatório"));
			continua = false;
		}else if(ferias.getDias_vendidos() == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o número de dias vendidos: obrigatório"));
			continua = false;
		}else if(!(ferias.getDias_gozados() >= 20 && ferias.getDias_gozados() <= 30) ){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O número de dias gozados nao é permitido"));
			continua = false;
		}
		else if( !(ferias.getDias_vendidos() <= 10) ){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O número de dias vendidos nao é permitido"));
			continua = false;
		}
		else if( (ferias.getDias_gozados() + ferias.getDias_vendidos()) != 30){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A soma de dias gozados e vendidos precisa ser igual a 30"));
			continua = false;
		}
		return continua;
	}
	
	public String salvarFerias(){
		
			if(tratarSalvamento()){
				if(ferias.getId() == null){
					try {
						feriasDAO.cadastrar(ferias);
						ferias = new Ferias();
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
					} catch (Exception e) {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
					}
				}else{
					try {
						feriasDAO.alterar(ferias);
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado com sucesso!"));
					} catch (Exception e) {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
					}
				}
					
			}
			
			return "gerenciarferias";
		
	}
	
	
	public void excluirFerias(){
		if(ferias.getId() != null){
		
				try {
					ferias = feriasDAO.getPorId(ferias.getId());
					if(feriasDAO.excluir(ferias)){
						ferias = new Ferias();
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Deletado com sucesso!"));
					}else{
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não pode ser deletado"));
					}
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			
		}else{
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Para deletar o registro é necessario ter carregado os dados no formulario!"));
		}
		
	}
	
	public void limpar(){
		ferias = new Ferias();
		ferias.setFuncionario(new Funcionario());
		ferias.getFuncionario().setNome("");
	}
	
	public String prepararAdicionarFerias(){
		limpar();
		return "gerenciarferias";
	}
	
	public void prepararAlterarFerias(){
		ferias = (Ferias)listaFerias.getRowData();
	}	

	
	public String prepararAdicionarParcela(){
		ferias = (Ferias)listaFerias.getRowData();
		return "gerenciarparcelas";
	}
	

}
