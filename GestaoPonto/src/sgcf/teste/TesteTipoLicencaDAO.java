package sgcf.teste;

import sgcf.persistencia.dao.TipoLicencaDAO;
import sgcf.persistencia.entidade.TipoLicenca;

public class TesteTipoLicencaDAO {
	public static void main(String[] args) {
		TipoLicencaDAO tipolicencadao = new TipoLicencaDAO();
		
		TipoLicenca tipolicenca = new TipoLicenca();
		
		tipolicenca.setNome("maternidade");
		
		tipolicencadao.cadastrar(tipolicenca);
		
	}
}
