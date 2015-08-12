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
public class Parcela {
	@Id
	@SequenceGenerator(name="PARCELA_ID", sequenceName="parcela_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="PARCELA_ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="ferias")
	private Ferias ferias;
	
	private Date data_ini;
	
	private Date data_fim;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Ferias getFerias() {
		return ferias;
	}

	public void setFerias(Ferias ferias) {
		this.ferias = ferias;
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
		Parcela other = (Parcela) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
