package sgcf.persistencia.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Evento {
	@Id
	@SequenceGenerator(name="EVENTO_ID",sequenceName="evento_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="EVENTO_ID")
	private Integer id;
	
	private String nome;
	
	private boolean horaextra;
	
	@OneToMany(mappedBy="evento")
	private List<LinhaEvento> linhas = new ArrayList<LinhaEvento>();

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

	public boolean isHoraextra() {
		return horaextra;
	}

	public void setHoraextra(boolean horaextra) {
		this.horaextra = horaextra;
	}

	public List<LinhaEvento> getLinhas() {
		return linhas;
	}

	public void setLinhas(List<LinhaEvento> linhas) {
		this.linhas = linhas;
	}

	@Override
	public String toString() {
		return nome;
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
		Evento other = (Evento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
