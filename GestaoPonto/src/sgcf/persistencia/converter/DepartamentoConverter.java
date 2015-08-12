package sgcf.persistencia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sgcf.persistencia.dao.DepartamentoDAO;
import sgcf.persistencia.entidade.Departamento;

@FacesConverter(value="departamentoConverter")
public class DepartamentoConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Departamento departamento = new Departamento();
		try {
			Integer id = Integer.parseInt(value);
			departamento = new DepartamentoDAO().getPorId(id);
		} catch (Exception d) {
			d.printStackTrace();
			return null;
		}
		return departamento;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object departamento) {
		if (departamento instanceof Departamento) {
			Departamento d = (Departamento) departamento;

			return d.getId().toString();
		}
		return "";
	}

}
