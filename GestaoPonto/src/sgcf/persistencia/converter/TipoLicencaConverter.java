package sgcf.persistencia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sgcf.persistencia.dao.TipoLicencaDAO;
import sgcf.persistencia.entidade.TipoLicenca;

@FacesConverter(value="tipoLicencaConverter")
public class TipoLicencaConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		TipoLicenca tipoLicenca = new TipoLicenca();
		try {
			Integer id = Integer.parseInt(value);
			tipoLicenca = new TipoLicencaDAO().getPorId(id);
		} catch (Exception tl) {
			tl.printStackTrace();
			return null;
		}
		return tipoLicenca;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object tipoLicenca) {
		if (tipoLicenca instanceof TipoLicenca) {
			TipoLicenca tl = (TipoLicenca) tipoLicenca;

			return tl.getId().toString();
		}
		return "";
	}

}
