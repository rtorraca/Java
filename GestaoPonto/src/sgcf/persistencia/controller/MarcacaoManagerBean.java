package sgcf.persistencia.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;

import sgcf.persistencia.dao.DiaDaSemanaDAO;
import sgcf.persistencia.dao.MarcacaoDAO;
import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.entidade.DiaDaSemana;
import sgcf.persistencia.entidade.Marcacao;
import sgcf.persistencia.entidade.Funcionario;

@ManagedBean(name="marcacaoManagerBean")
@RequestScoped
public class MarcacaoManagerBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2464019061018296019L;
	private MarcacaoDAO marcacaoDAO = new MarcacaoDAO();
	private Marcacao marcacao = new Marcacao();
	private Marcacao entrada = new Marcacao();
	private Integer hora;
	private Integer minuto;
	private DataModel listaMarcacaos;

	public MarcacaoManagerBean(){
		System.out.println("Construtor de MarcacaoManagerBean");
		marcacao = new Marcacao();
		marcacao.setDia(new DiaDaSemana());
	}
	
	public Marcacao getMarcacao() {
		return marcacao;
	}

	public void setMarcacao(Marcacao marcacao) {
		this.marcacao = marcacao;
	}

	public void setHora(Integer hora) {
		this.hora = hora;
	}

	public Integer getHora() {
		return hora;
	}

	public void setMinuto(Integer minuto) {
		this.minuto = minuto;
	}

	public Integer getMinuto() {
		return minuto;
	}

	public DataModel getListaMarcacaos() {
		MarcacaoDAO marcacaoDAO = new MarcacaoDAO();
		List<Marcacao> lista = new ArrayList<Marcacao>(); 
		if(marcacao.getDia() == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Selecione o dia"));
		}else{
			marcacaoDAO.getListaPorDiaDaSemana(marcacao.getDia());
		}
		listaMarcacaos = new ListDataModel(lista);
		return listaMarcacaos;
	}
	


	public void setListaMarcacaos(DataModel listaMarcacaos) {
		this.listaMarcacaos = listaMarcacaos;
	}
	
	public List<DiaDaSemana> getListaDias(){
		return new DiaDaSemanaDAO().getLista();
	}
	
	public List<Funcionario> getListaFuncionarios(){
		return new FuncionarioDAO().getLista();
	}
	
	public boolean tratarSalvamento(){
		boolean continua = true;
		if(marcacao.getNome() == null || marcacao.getNome().isEmpty()){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o nome: obrigatorio!"));
			continua = false;
		}else if(hora == null || minuto == null){
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Entre com o horário: obrigatorio!"));
			continua = false;
		}else{
		
			List<Marcacao> marcacaos = new ArrayList<Marcacao>();
			marcacaos = marcacaoDAO.getListaPorDiaDaSemana(marcacao.getDia());		
			
			Calendar c = Calendar.getInstance();
			c.set(1970, 0, 1, hora, minuto);
			Date d = new Date();
			d.setTime(c.getTimeInMillis());
			marcacao.setHorario(d);
			
			entrada = null;
			for (Marcacao marcacao2 : marcacaos) {
				if( marcacao2.getTipomarcacao() == 'e'){
					if( marcacao2.getSaida() == null  ){
						if( marcacao.getId() == null || (marcacao.getId() != null && !marcacao.getId().equals(marcacao2.getId()) ) ){
							entrada = marcacao2;
						}
					}
				}
			}
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			Double total = 0.0;
			Double diferenca = 0.0;
			Double horasini = 0.0;
			Double horasfim = 0.0;
		
			
			if(entrada != null ){
				if( marcacao.getTipomarcacao() == 'e'){
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Existe entrada sem saída"));
					return false;
				}else{
					
				
					for (Marcacao marcacao1 : marcacaos) {
						if(marcacao1.getSaida() != null){
							
							c1.setTime(marcacao1.getHorario());
							c2.setTime(marcacao1.getSaida().getHorario());
							horasini = (double) (c1.get(Calendar.HOUR_OF_DAY) + ((double)c1.get(Calendar.MINUTE)/60));
							horasfim = (double) (c2.get(Calendar.HOUR_OF_DAY) + ((double)c2.get(Calendar.MINUTE)/60));
		
							diferenca = horasfim - horasini;
							total += diferenca;
						}
					}
					c1.setTime(entrada.getHorario());
					c2.setTime(marcacao.getHorario());
					horasini = (double) (c1.get(Calendar.HOUR_OF_DAY) + ((double)c1.get(Calendar.MINUTE)/60));
					horasfim = (double) (c2.get(Calendar.HOUR_OF_DAY) + ((double)c2.get(Calendar.MINUTE)/60));
					diferenca = horasfim - horasini;
					if(diferenca < 0){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("A saída deve ser maior que a entrada!"));
						return false;
					}else{
						total += diferenca;
						System.out.println("Total: "+ total);
						if(total > entrada.getDia().getJornada()){
							FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Ultrapassou o limite da jornada do dia"));
							return false;
						}
					}
				}
			}else{
				if( marcacao.getTipomarcacao() == 'e'){
					for (Marcacao marcacao3 : marcacaos) {
						if(marcacao3.getSaida() != null){
							c1.setTime(marcacao.getHorario());
							c2.setTime(marcacao3.getSaida().getHorario());
							horasini = (double) (c1.get(Calendar.HOUR_OF_DAY) + ((double)c1.get(Calendar.MINUTE)/60));
							horasfim = (double) (c2.get(Calendar.HOUR_OF_DAY) + ((double)c2.get(Calendar.MINUTE)/60));
		
							diferenca = horasfim - horasini;
							if(diferenca >= 0){
								FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("O horario está incluso em outro par de entrada e saída"));
								return false;
							}
						}
					}
					
				}else{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Não existe entrada para essa saída"));
					return false;
				}
			}
			
			for (Marcacao itemLista : marcacaos) {
		
				
				if( itemLista.getNome().equals(marcacao.getNome()) ){
					if( marcacao.getId() == null || (marcacao.getId() == null && !itemLista.getId().equals(marcacao.getId()))  ){
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Nome da Marcacao já existe!"));
						return false;
					}
				}
				
			}
		}
		return continua;
	}
	

	public void salvarMarcacao(){
		if(tratarSalvamento()){
			Calendar c = Calendar.getInstance();
			c.set(2011, 01, 01, hora, minuto);
			Date d = new Date();
			d.setTime(c.getTimeInMillis());
			marcacao.setHorario(d);
			if(marcacao.getId() == null){
				try {
					if(marcacao.getTipomarcacao() == 'e')
						marcacaoDAO.cadastrar(marcacao);
					else{
						marcacaoDAO.cadastrar(marcacao);
						entrada.setSaida(marcacao);
						marcacaoDAO.alterar(entrada);
					}
					this.limpar();
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}else{
				try {
					marcacaoDAO.alterar(marcacao);
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Salvo com sucesso!"));
				} catch (Exception e) {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(e.getMessage()));
				}
			}
		}
	
	}
	
	public void excluirMarcacao(){
		if(marcacao.getId() != null){
			System.out.println(marcacao.getId().toString());
			try {
				marcacao = marcacaoDAO.getPorId(marcacao.getId());
				if(marcacaoDAO.excluir(marcacao)){
					this.limpar();
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
		DiaDaSemana dia = marcacao.getDia();
		marcacao = new Marcacao();
		marcacao.setDia(dia);
	}
	
	public String prepararAdicionarMarcacao(){
		limpar();
		return "gerenciarmarcacao";
	}
	
	
	public void prepararAlterarMarcacao(){
		marcacao = new Marcacao();
		marcacao = (Marcacao)listaMarcacaos.getRowData();
	}
}
