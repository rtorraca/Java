package sgcf.persistencia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sgcf.persistencia.dao.TurnoDAO;
import sgcf.persistencia.entidade.Turno;

@FacesConverter(value="turnoConverter")
public class TurnoConverter implements Converter{
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Turno turno = new Turno();
		try {
			Integer id = Integer.parseInt(value);
			turno = new TurnoDAO().getPorId(id);
		} catch (Exception d) {
			d.printStackTrace();
			return null;
		}
		return turno;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object turno) {
		if (turno instanceof Turno) {
			Turno t = (Turno) turno;

			return t.getId().toString();
		}
		return "";
	}
}
