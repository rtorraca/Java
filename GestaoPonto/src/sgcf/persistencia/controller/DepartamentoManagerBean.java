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

import sgcf.persistencia.dao.DepartamentoDAO;
import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.entidade.Departamento;
import sgcf.persistencia.entidade.Funcionario;
@ManagedBean(name="departamentoManagerBean")
@RequestScoped
public class DepartamentoManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1553775190058814621L;
	private DepartamentoDAO departamentoDAO = new DepartamentoDAO();
	private Departamento departamento = new Departamento();
	private DataModel listaDepartamentos;

	public DepartamentoManagerBean(){
		
	}
	
	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public DataModel getListaDepartamentos() {
		DepartamentoDAO departamentoDAO = new DepartamentoDAO();
		List<Departamento> lista = departamentoDAO.getLista();
		listaDepartamentos = new ListDataModel(lista);
		return listaDepartamentos;
	}

	public void setListaDepartamentos(DataModel listaDepartamentos) {
		this.listaDepartamentos = listaDepartamentos;
	}
	
	public List<Funcionario> getListaFuncionarios(){
		return new FuncionarioDAO().getLista();
	}
	
	public boolean tratarSalvamento(){
		boolean continua = true;
		if(departamento.getNome() == null || departamento.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o nome: obrigatorio!"));
			continua = false;
		}else{
			List<Departamento> departamentos = new ArrayList<Departamento>();
			departamentos = departamentoDAO.getLista();
			
			for (Departamento itemLista : departamentos) {
				
				if( itemLista.getNome().equals(departamento.getNome()) ){
					if( departamento.getId() == null || (departamento.getId() != null && !itemLista.getId().equals(departamento.getId()))  ){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Departamento já existe!"));
						return false;
					}
				}
				
			}
		}
		return continua;
	}
	

	public void salvarDepartamento(){
		if(tratarSalvamento()){
			if(departamento.getId() == null){
				try {
					departamentoDAO.cadastrar(departamento);
					departamento = new Departamento();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}else{
				try {
					departamentoDAO.alterar(departamento);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
	
	}
	
	public void excluirDepartamento(){
		if(departamento.getId() != null){
			System.out.println(departamento.getId().toString());
			try {
				departamento = departamentoDAO.getPorId(departamento.getId());
				if(departamentoDAO.excluir(departamento)){
					departamento = new Departamento();
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
		departamento = new Departamento();
	}
	
	public String prepararAdicionarDepartamento(){
		limpar();
		return "gerenciardepartamento";
	}
	
	
	public void prepararAlterarDepartamento(){
		departamento = (Departamento)listaDepartamentos.getRowData();
	}
}
