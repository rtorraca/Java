package sgcf.persistencia.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Funcionario_turno {
	
	@Id
	@SequenceGenerator(name="FUNCIONARIOTURNO_ID", sequenceName="funcionario_turno_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="FUNCIONARIOTURNO_ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="funcionario")
	private Funcionario funcionario;
	
	@ManyToOne
	@JoinColumn(name="turno")
	private Turno turno;
	
	private Date data_ini;
	
	private Date data_fim;

	public Funcionario getFuncionario() {
		return funcionario;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}

	public Turno getTurno() {
		return turno;
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public Date getData_ini() {
		return data_ini;
	}

	public void setData_ini(Date data_ini) {
		this.data_ini = data_ini;
	}

	public Date getData_fim() {
		return data_fim;
	}

	public void setData_fim(Date data_fim) {
		this.data_fim = data_fim;
	}

	@Override
	public String toString() {
		return "Funcionario_turno [funcionario=" + funcionario.getNome() + ", turno="
				+ turno.getNome() + ", data_ini=" + data_ini + ", data_fim=" + data_fim
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((data_fim == null) ? 0 : data_fim.hashCode());
		result = prime * result
				+ ((data_ini == null) ? 0 : data_ini.hashCode());
		result = prime * result
				+ ((funcionario == null) ? 0 : funcionario.hashCode());
		result = prime * result + ((turno == null) ? 0 : turno.hashCode());
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
		Funcionario_turno other = (Funcionario_turno) obj;
		if (data_fim == null) {
			if (other.data_fim != null)
				return false;
		} else if (!data_fim.equals(other.data_fim))
			return false;
		if (data_ini == null) {
			if (other.data_ini != null)
				return false;
		} else if (!data_ini.equals(other.data_ini))
			return false;
		if (funcionario == null) {
			if (other.funcionario != null)
				return false;
		} else if (!funcionario.equals(other.funcionario))
			return false;
		if (turno == null) {
			if (other.turno != null)
				return false;
		} else if (!turno.equals(other.turno))
			return false;
		return true;
	}
	
	
	
	
}
