package sgcf.persistencia.entidade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Registro {
	@Id
	@SequenceGenerator(name="REGISTRO_ID", sequenceName="registro_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="REGISTRO_ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="funcionario")
	private Funcionario funcionario;
	
	@OneToMany(mappedBy="registro")
	private List<ItemDeRegistro> itensregistro = new ArrayList<ItemDeRegistro>();
	
	@OneToMany(mappedBy="registro")
	private List<LinhaEvento> linhas = new ArrayList<LinhaEvento>();
	
	private Date data;
	
	private Double jornadacumprida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public List<ItemDeRegistro> getItensregistro() {
		return itensregistro;
	}

	public void setItensregistro(List<ItemDeRegistro> itensregistro) {
		this.itensregistro = itensregistro;
	}

	public List<LinhaEvento> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<LinhaEvento> linhas) {
		this.linhas = linhas;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Double getJornadacumprida() {
		return jornadacumprida;
	}

	public void setJornadacumprida(Double jornadacumprida) {
		this.jornadacumprida = jornadacumprida;
	}

	@Override
	public String toString() {
		return id.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Registro other = (Registro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
