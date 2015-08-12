package sgcf.persistencia.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.entidade.Funcionario;

@FacesConverter(value="funcionarioConverter")
public class FuncionarioConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Funcionario funcionario = new Funcionario();
		try {
			Integer id = Integer.parseInt(value);
			funcionario = new FuncionarioDAO().getPorId(id);
		} catch (Exception f) {
			f.printStackTrace();
			return null;
		}
		return funcionario;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object funcionario) {
		if (funcionario instanceof Funcionario) {
			Funcionario f = (Funcionario) funcionario;
			return f.getId().toString();
		}
		return "";
	}

}
