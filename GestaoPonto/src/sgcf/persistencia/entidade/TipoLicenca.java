package sgcf.persistencia.entidade;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name="tipolicenca")
public class TipoLicenca {
	@Id
	@SequenceGenerator(name="TIPOLICENCA_ID", sequenceName="tipolicenca_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="TIPOLICENCA_ID")
	private Integer id;
	
	@OneToMany(mappedBy="tipolicenca")
	private List<Licenca> listaLicenca = new ArrayList<Licenca>();
	
	private String nome;

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

	public void setListaLicenca(List<Licenca> listaLicenca) {
		this.listaLicenca = listaLicenca;
	}

	public List<Licenca> getListaLicenca() {
		return listaLicenca;
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
		TipoLicenca other = (TipoLicenca) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
