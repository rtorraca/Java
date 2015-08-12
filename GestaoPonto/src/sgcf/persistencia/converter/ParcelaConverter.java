package sgcf.persistencia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sgcf.persistencia.dao.ParcelaDAO;
import sgcf.persistencia.entidade.Parcela;

@FacesConverter(value="parcelaConverter")
public class ParcelaConverter implements Converter {
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Parcela parcela = new Parcela();
		try {
			Integer id = Integer.parseInt(value);
			parcela = new ParcelaDAO().getPorId(id);
		} catch (Exception p) {
			p.printStackTrace();
			return null;
		}
		return parcela;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object parcela) {
		if (parcela instanceof Parcela) {
			Parcela p = (Parcela) parcela;

			return p.getId().toString();
		}
		return "";
	}

}
