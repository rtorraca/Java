package sgcf.persistencia.entidade;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class ItemDeRegistro {
	@Id
	@SequenceGenerator(name="ITEMDEREGISTRO_ID", sequenceName="itemderegistro_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="ITEMDEREGISTRO_ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="registro")
	private Registro registro;
	
	@ManyToOne
	@JoinColumn(name="tiporegistro")
	private TipoRegistro tiporegistro;
	
	private char tipomarcacao;
	
	@Temporal(TemporalType.TIME)
	private Date horario;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
	}

	public TipoRegistro getTiporegistro() {
		return tiporegistro;
	}

	public void setTiporegistro(TipoRegistro tiporegistro) {
		this.tiporegistro = tiporegistro;
	}

	public char getTipomarcacao() {
		return tipomarcacao;
	}

	public void setTipomarcacao(char tipomarcacao) {
		this.tipomarcacao = tipomarcacao;
	}

	public Date getHorario() {
		return horario;
	}

	public void setHorario(Date horario) {
		this.horario = horario;
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
		ItemDeRegistro other = (ItemDeRegistro) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
