package sgcf.persistencia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sgcf.persistencia.dao.FeriasDAO;
import sgcf.persistencia.entidade.Ferias;

@FacesConverter(value="feriasConverter")
public class FeriasConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Ferias ferias = new Ferias();
		try {
			Integer id = Integer.parseInt(value);
			ferias = new FeriasDAO().getPorId(id);
		} catch (Exception f) {
			f.printStackTrace();
			return null;
		}
		return ferias;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object ferias) {
		if (ferias instanceof Ferias) {
			Ferias f = (Ferias) ferias;

			return f.getId().toString();
		}
		return "";
	}

}
