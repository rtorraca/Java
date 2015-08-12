package sgcf.persistencia.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Turno {

	@Id
	@SequenceGenerator(name="TURNO_ID", sequenceName="turno_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TURNO_ID")
	private Integer id;
	
	private String nome;
	
	@OneToMany(mappedBy="turno")
	private List<DiaDaSemana> dias = new ArrayList<DiaDaSemana>();
	
	@OneToMany(mappedBy="turno")
	private List<Funcionario_turno> funcionarioturnos = new ArrayList<Funcionario_turno>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	

	public void setDias(List<DiaDaSemana> dias) {
		this.dias = dias;
	}

	public List<DiaDaSemana> getDias() {
		return dias;
	}

	public List<Funcionario_turno> getFuncionarioturnos() {
		return funcionarioturnos;
	}

	public void setFuncionarioturnos(List<Funcionario_turno> funcionarioturnos) {
		this.funcionarioturnos = funcionarioturnos;
	}

	@Override
	public String toString() {
		return "Turno [nome=" + nome + "]";
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
		Turno other = (Turno) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
