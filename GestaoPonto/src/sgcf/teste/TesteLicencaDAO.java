package sgcf.teste;

import java.util.Calendar;
import java.util.Date;

import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.dao.LicencaDAO;
import sgcf.persistencia.dao.TipoLicencaDAO;
import sgcf.persistencia.entidade.Funcionario;
import sgcf.persistencia.entidade.Licenca;
import sgcf.persistencia.entidade.TipoLicenca;

public class TesteLicencaDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LicencaDAO licencaDAO = new LicencaDAO();
		
		Funcionario funcionario = new FuncionarioDAO().getPorId(3);
		TipoLicenca tipolicenca = new TipoLicencaDAO().getPorId(1);
		
		Licenca licenca = new Licenca();
		Date data_ini = new Date("01/06/11");
		Date data_fim = new Date("20/06/11");
	
		licenca.setFuncionario(funcionario);
		licenca.setTipolicenca(tipolicenca);
		licenca.setData_ini(data_ini);
		licenca.setData_fim(data_fim);
		
		licencaDAO.cadastrar(licenca);
	}

}
