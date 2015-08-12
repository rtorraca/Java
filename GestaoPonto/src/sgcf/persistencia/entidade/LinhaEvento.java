package sgcf.persistencia.entidade;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class LinhaEvento {
	@Id
	@SequenceGenerator(name="LINHAEVENTO_ID", sequenceName="linhaevento_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="LINHAEVENTO_ID")
	private Integer id;
	
	private String justificativa;
	
	private Byte[] documento;
	
	private boolean validado;
	
	private Double duracao;
	
	@ManyToOne
	@JoinColumn(name="evento")
	private Evento evento;
	
	@ManyToOne
	@JoinColumn(name="tipojustificativa")
	private TipoJustificativa tipojustificativa;
	
	@ManyToOne
	@JoinColumn(name="registro")
	private Registro registro;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}

	public Byte[] getDocumento() {
		return documento;
	}

	public void setDocumento(Byte[] documento) {
		this.documento = documento;
	}

	public boolean isValidado() {
		return validado;
	}

	public void setValidado(boolean validado) {
		this.validado = validado;
	}

	public Double getDuracao() {
		return duracao;
	}

	public void setDuracao(Double duracao) {
		this.duracao = duracao;
	}

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}

	public TipoJustificativa getTipojustificativa() {
		return tipojustificativa;
	}

	public void setTipojustificativa(TipoJustificativa tipojustificativa) {
		this.tipojustificativa = tipojustificativa;
	}

	public Registro getRegistro() {
		return registro;
	}

	public void setRegistro(Registro registro) {
		this.registro = registro;
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
		LinhaEvento other = (LinhaEvento) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
}
