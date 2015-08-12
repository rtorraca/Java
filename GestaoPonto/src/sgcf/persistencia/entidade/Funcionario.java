package sgcf.persistencia.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Funcionario {
	@Id
	@SequenceGenerator(name="FUNCIONARIO_ID", sequenceName="funcionario_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="FUNCIONARIO_ID")
	private Integer id;
	
	private Integer matricula;
	
	@ManyToOne
	@JoinColumn(name="depto")
	private Departamento depto;
	
	private String nome;
	
	private String pis;
	
	
	private String cpf;
	
	@OneToMany(mappedBy="id", fetch=FetchType.LAZY)
	private List<Funcionario> subordinados = new ArrayList<Funcionario>();
	
	@ManyToOne
	@JoinColumn(name="chefe", insertable=true, updatable=true)
	@Fetch(FetchMode.JOIN)
	private Funcionario chefe;
	
	@OneToMany(mappedBy="funcionario")
	private List<Registro> registros = new ArrayList<Registro>();
	
	@OneToMany(mappedBy="funcionario")
	private List<Funcionario_turno> funcionarioturnos = new ArrayList<Funcionario_turno>(); 
	
	private Double saldo_horas;
	
	private String login;
	
	private String senha;
	
	private String email;
	
	@OneToMany(mappedBy="funcionario")
	private List<Ferias> listaFerias = new ArrayList<Ferias>();
	
	@OneToMany(mappedBy="funcionario")
	private List<Licenca> listaLicenca = new ArrayList<Licenca>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public Departamento getDepto() {
		return depto;
	}

	public void setDepto(Departamento depto) {
		this.depto = depto;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Funcionario getChefe() {
		if(chefe == null){
			chefe = new Funcionario();
			chefe.setNome("sem chefe");
		}
		return chefe;
	}

	public void setChefe(Funcionario chefe) {
		this.chefe = chefe;
	}

	public void setSubordinados(List<Funcionario> subordinados) {
		this.subordinados = subordinados;
	}

	public List<Funcionario> getSubordinados() {
		return subordinados;
	}

	public List<Registro> getRegistros() {
		return registros;
	}

	public void setRegistros(List<Registro> registros) {
		this.registros = registros;
	}

	public List<Funcionario_turno> getFuncionarioturnos() {
		return funcionarioturnos;
	}

	public void setFuncionarioturnos(List<Funcionario_turno> funcionarioturnos) {
		this.funcionarioturnos = funcionarioturnos;
	}

	public Double getSaldo_horas() {
		return saldo_horas;
	}

	public void setSaldo_horas(Double saldo_horas) {
		this.saldo_horas = saldo_horas;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Ferias> getListaFerias() {
		return listaFerias;
	}

	public void setListaFerias(List<Ferias> listaFerias) {
		this.listaFerias = listaFerias;
	}

	public void setListaLicenca(List<Licenca> listaLicenca) {
		this.listaLicenca = listaLicenca;
	}

	public List<Licenca> getListaLicenca() {
		return listaLicenca;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return nome;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
