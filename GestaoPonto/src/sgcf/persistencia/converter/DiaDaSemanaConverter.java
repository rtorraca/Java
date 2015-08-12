package sgcf.persistencia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sgcf.persistencia.dao.DiaDaSemanaDAO;
import sgcf.persistencia.entidade.DiaDaSemana;

@FacesConverter(value="diaDaSemanaConverter")
public class DiaDaSemanaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		DiaDaSemana diaDaSemana = new DiaDaSemana();
		try {
			Integer id = Integer.parseInt(value);
			diaDaSemana = new DiaDaSemanaDAO().getPorId(id);
		} catch (Exception d) {
			d.printStackTrace();
			return null;
		}
		return diaDaSemana;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object diaDaSemana) {
		if (diaDaSemana instanceof DiaDaSemana) {
			DiaDaSemana d = (DiaDaSemana) diaDaSemana;

			return d.getId().toString();
		}
		return "";
	}
}
