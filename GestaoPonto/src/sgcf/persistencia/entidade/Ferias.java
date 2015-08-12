package sgcf.persistencia.entidade;

import java.util.ArrayList;
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
public class Ferias {
	@Id
	@SequenceGenerator(name="FERIAS_ID", sequenceName="ferias_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="FERIAS_ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="funcionario")
	private Funcionario funcionario;
	
	private Integer dias_gozados;
	
	private Integer dias_vendidos;
	
	@OneToMany(mappedBy="ferias")
	private List<Parcela> listaParcela  = new ArrayList<Parcela>();

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

	public Integer getDias_gozados() {
		return dias_gozados;
	}

	public void setDias_gozados(Integer dias_gozados) {
		this.dias_gozados = dias_gozados;
	}

	public Integer getDias_vendidos() {
		return dias_vendidos;
	}

	public void setDias_vendidos(Integer dias_vendidos) {
		this.dias_vendidos = dias_vendidos;
	}

	public List<Parcela> getListaParcela() {
		return listaParcela;
	}

	public void setListaParcela(List<Parcela> listaParcela) {
		this.listaParcela = listaParcela;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
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
		Ferias other = (Ferias) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
}
