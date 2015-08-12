package sgcf.persistencia.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Marcacao {
	@Id
	@SequenceGenerator(name="MARCACAO_ID",sequenceName="marcacao_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO,generator="MARCACAO_ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="dia")
	private DiaDaSemana dia;
	
	private char tipomarcacao;
	
	private String nome;
	
	private Date horario;
	
	
	@OneToOne
	@JoinColumn(name="saida", insertable=true, updatable=true)
	private Marcacao saida;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public DiaDaSemana getDia() {
		return dia;
	}

	public void setDia(DiaDaSemana dia) {
		this.dia = dia;
	}

	public char getTipomarcacao() {
		return tipomarcacao;
	}

	public void setTipomarcacao(char tipomarcacao) {
		this.tipomarcacao = tipomarcacao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
	}


	public Marcacao getSaida() {
		return saida;
	}

	public void setSaida(Marcacao saida) {
		this.saida = saida;
	}

	@Override
	public String toString() {
		return "Marcacao [nome=" + nome + "]";
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
		Marcacao other = (Marcacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
