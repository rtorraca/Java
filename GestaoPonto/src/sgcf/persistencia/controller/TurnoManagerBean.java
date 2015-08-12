package sgcf.persistencia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;


import sgcf.persistencia.dao.DiaDaSemanaDAO;
import sgcf.persistencia.dao.Funcionario_turnoDAO;
import sgcf.persistencia.dao.TurnoDAO;
import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.dao.TurnoDAO;
import sgcf.persistencia.entidade.DiaDaSemana;
import sgcf.persistencia.entidade.Funcionario_turno;
import sgcf.persistencia.entidade.Turno;
import sgcf.persistencia.entidade.Funcionario;
import sgcf.persistencia.entidade.Turno;
import sgcf.persistencia.entidade.Turno;

@ManagedBean(name="turnoManagerBean")
@RequestScoped
public class TurnoManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2565781375857558202L;
	private Turno turno = new Turno();
	private DataModel listaTurnos;
	private DataModel listaDias;
	private TurnoDAO turnoDAO = new TurnoDAO();
	private Funcionario funcionario = new Funcionario();

	public TurnoManagerBean(){
		System.out.println("Construtor de TurnoManagerBean");
		this.limpar();
	}
	
	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public DataModel getListaTurnos() {
		TurnoDAO turnoDAO = new TurnoDAO();
		List<Turno> lista = turnoDAO.getLista();
		listaTurnos = new ListDataModel(lista);
		return listaTurnos;
	}

	public void setListaTurnos(DataModel listaTurnos) {
		this.listaTurnos = listaTurnos;
	}
	
	public List<Funcionario> getListaFuncionarios(){
		return new FuncionarioDAO().getLista();
	}
	
	public DataModel getListaDias(){
		List<DiaDaSemana> dias = new ArrayList<DiaDaSemana>();
		if(turno == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecione o turno"));
		}else{
			dias = new DiaDaSemanaDAO().getListaPorTurno(turno);
			listaDias = new ListDataModel(dias);
		}
		return listaDias;
	}
	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public boolean tratarSalvamento(){
		boolean continua = true;
		if(turno.getNome() == null || turno.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o nome: obrigatorio!"));
			continua = false;
		}else{
			List<Turno> turnos = new ArrayList<Turno>();
			turnos = turnoDAO.getLista();
			
			for (Turno itemLista : turnos) {
				
				if( itemLista.getNome().equals(turno.getNome()) ){
					if( turno.getId() == null || (turno.getId() != null && !itemLista.getId().equals(turno.getId()))  ){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Turno já existe!"));
						return false;
					}
				}
				
			}
		}
		return continua;
	}
	

	public void salvarTurno(){
		if(tratarSalvamento()){
			if(turno.getId() == null){
				try {
					turnoDAO.cadastrar(turno);
					turno = new Turno();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}else{
				try {
					turnoDAO.alterar(turno);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
	
	}
	
	public String adicionarFuncionario(){
		
		Funcionario_turnoDAO fuTurnoDAO = new Funcionario_turnoDAO();
		
		Funcionario_turno fuTurno = new Funcionario_turno();
		
		fuTurno.setFuncionario(funcionario);
		
		fuTurno.setTurno(turno);
		
		fuTurno.setData_ini(Calendar.getInstance().getTime());
		
		fuTurno.setData_fim(null);
		try {
			fuTurnoDAO.cadastrar(fuTurno);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
			funcionario = new Funcionario();
			funcionario.setNome("");
		} catch (Exception e) {
			e.printStackTrace();
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nao pode ser inserido!"));
		}
		
		
		return "gerenciarturno";
		
	}
	
	public void excluirTurno(){
		if(turno.getId() != null){
			System.out.println(turno.getId().toString());
			try {
				turno = turnoDAO.getPorId(turno.getId());
				if(turnoDAO.excluir(turno)){
					turno = new Turno();
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
		turno = new Turno();
		funcionario = new Funcionario();
		funcionario.setNome("");
	}
	
	public String prepararAdicionarTurno(){
		limpar();
		return "gerenciarturno";
	}
	
	
	public void prepararAlterarTurno(){
		turno = (Turno)listaTurnos.getRowData();
	}
	
	public void verificar(){
		if(turno.getId() == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecione o turno"));
		}
	}
	
	

		
}
