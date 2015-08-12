package sgcf.persistencia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import sgcf.persistencia.dao.DepartamentoDAO;
import sgcf.persistencia.dao.FeriasDAO;
import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.dao.LicencaDAO;
import sgcf.persistencia.entidade.Departamento;
import sgcf.persistencia.entidade.Ferias;
import sgcf.persistencia.entidade.Funcionario;
import sgcf.persistencia.entidade.Licenca;


@ManagedBean(name="funcionarioManagerBean")
@RequestScoped
public class FuncionarioManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9203960483643059256L;
	private Funcionario funcionario = new Funcionario();
	private DataModel listaFuncionarios;
	private List<Funcionario> lista = new ArrayList<Funcionario>();
	private FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
	
	public FuncionarioManagerBean(){
		System.out.println("Construtor de FuncionarioManagerBean");
		lista = funcionarioDAO.getLista();
		if(funcionario == null){
			funcionario = new Funcionario();
			funcionario.setNome("");
		}
		
	}
	
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public DataModel getListaFuncionarios() {
		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		List<Funcionario> lista = funcionarioDAO.getLista();
		listaFuncionarios = new ListDataModel(lista);
		return listaFuncionarios;
	}

	public void setListaFuncionarios(DataModel listaFuncionarios) {
		this.listaFuncionarios = listaFuncionarios;
	}
	
	public List<Funcionario> getListaFuncionario(){
		return funcionarioDAO.getLista();
	}
	
	public List<Funcionario> complemento(Object event){
		
		String prefixo = event.toString().toLowerCase();        

	      List<Funcionario> retorno = new ArrayList<Funcionario>();

	      for(int pos = 0; pos < lista.size(); pos++){

	          if(lista.get(pos).getNome().toLowerCase().startsWith(prefixo)){               

	              retorno.add(lista.get(pos));

	          }

	      }

	      return retorno;
	}
	
	public List<Funcionario> getListaChefes(){
		return funcionarioDAO.getLista();
	}
	public List<Departamento> getListaDepartamentos(){
		return new DepartamentoDAO().getLista();
	}
	public List<Ferias> getListaFerias(){
		return new FeriasDAO().getLista();
	}
	
	public List<Licenca> getListaLicencas(){
		return new LicencaDAO().getLista();
	}
	

	public boolean tratarSalvamento(){
		boolean continua = true;
		
		if( funcionario.getMatricula() == null || funcionario.getMatricula().equals(0)){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com a matricula: obrigatorio!"));
			continua = false;
		}else if( funcionario.getPis() == null || funcionario.getPis().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o pis: obrigatorio!"));
			continua = false;
		}else if( funcionario.getCpf() == null || funcionario.getCpf().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com a cpf: obrigatorio!"));
			continua = false;
		}else if(funcionario.getNome() == null || funcionario.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o nome: obrigatorio!"));
			continua = false;
		}else if( funcionario.getLogin() == null || funcionario.getLogin().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o login: obrigatorio!"));
			continua = false;
		}else if( funcionario.getSenha() == null || funcionario.getSenha().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com a senha: obrigatorio!"));
			continua = false;
		}else if( funcionario.getEmail() == null || funcionario.getEmail().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o email: obrigatorio!"));
			continua = false;
		}else{
			List<Funcionario> funcionarios = new ArrayList<Funcionario>();
			funcionarios = funcionarioDAO.getLista();
			for (Funcionario itemLista : funcionarios) {
				if( funcionario.getMatricula().equals(itemLista.getMatricula()) ){
					if(funcionario.getId() == null || (funcionario.getId() != null && !funcionario.getId().equals(itemLista.getId()) ) ){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O funcionário já existe!"));
						return false;
					}
				}
			}
		}
		return continua;
	}
	
	public void salvarFuncionario(){
		if(tratarSalvamento()){
			if(funcionario.getId() == null){
				
				try {
					funcionarioDAO.cadastrar(funcionario);
					funcionario = new Funcionario();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}else{
				try {
					funcionarioDAO.alterar(funcionario);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Atualizado com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
	}
	

	public void excluirFuncionario(){
		if(funcionario.getId() != null){
			
				try {
					funcionario = funcionarioDAO.getPorId(funcionario.getId());
					
					if(funcionarioDAO.excluir(funcionario)){
						funcionario = new Funcionario();
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
		funcionario = new Funcionario();
	}
	
	public String prepararAdicionarFuncionario(){
		limpar();
		return "gerenciarfuncionario";
	}
	
	
	public void prepararAlterarFuncionario(){
		funcionario = (Funcionario)listaFuncionarios.getRowData();
	}
}
