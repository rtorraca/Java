package sgcf.persistencia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sgcf.persistencia.dao.TipoDiaDAO;
import sgcf.persistencia.entidade.TipoDia;

@FacesConverter(value="tipoDiaConverter")
public class TipoDiaConverter implements Converter{

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoDia tipoDia = new TipoDia();
		try {
			Integer id = Integer.parseInt(value);
			tipoDia = new TipoDiaDAO().getPorId(id);
		} catch (Exception d) {
			d.printStackTrace();
			return null;
		}
		return tipoDia;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object tipoDia) {
		if (tipoDia instanceof TipoDia) {
			TipoDia t = (TipoDia) tipoDia;

			return t.getId().toString();
		}
		return "";
	}
}
