package sgcf.persistencia.entidade;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;


@Entity
public class DiaDaSemana {
	
	@Id
	@SequenceGenerator(name="DIADASEMANA_ID", sequenceName="diadasemana_id_seq")
	@GeneratedValue(strategy=GenerationType.AUTO, generator="DIADASEMANA_ID")
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name="turno")
	private Turno turno;

	private String nome;
	
	@ManyToOne
	@JoinColumn(name="tipodia")
	private TipoDia tipodia;
	
	private Double jornada;
	
	@OneToMany(mappedBy="dia")
	private List<Marcacao> marcacoes = new ArrayList<Marcacao>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Turno getTurno() {

		return turno;
		
	}

	public void setTurno(Turno turno) {
		this.turno = turno;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setTipodia(TipoDia tipodia) {
		this.tipodia = tipodia;
	}

	public TipoDia getTipodia() {
		return tipodia;
	}

	public void setJornada(Double jornada) {
		this.jornada = jornada;
	}

	public Double getJornada() {
		return jornada;
	}

	public void setMarcacoes(List<Marcacao> marcacoes) {
		this.marcacoes = marcacoes;
	}

	public List<Marcacao> getMarcacoes() {
		return marcacoes;
	}

	@Override
	public String toString() {
		return "DiaDaSemana [nome=" + nome + "]";
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
		DiaDaSemana other = (DiaDaSemana) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	
	
}
