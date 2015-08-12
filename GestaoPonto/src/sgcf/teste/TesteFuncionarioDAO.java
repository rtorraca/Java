package sgcf.teste;

import java.util.ArrayList;
import java.util.List;

import sgcf.persistencia.dao.DepartamentoDAO;
import sgcf.persistencia.dao.FuncionarioDAO;
import sgcf.persistencia.entidade.Departamento;
import sgcf.persistencia.entidade.Funcionario;

public class TesteFuncionarioDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		DepartamentoDAO departamentodao = new DepartamentoDAO();
		FuncionarioDAO funcionariodao = new FuncionarioDAO();
		
		Departamento depto = departamentodao.getPorId(2);
		Funcionario chefe = new Funcionario();
		chefe = funcionariodao.getPorId(3);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setMatricula(105);
		funcionario.setCpf("02506456483");
		funcionario.setDepto(depto);
		funcionario.setChefe(chefe);
		funcionario.setPis("54678794451");
		funcionario.setNome("Marcos da Silva");
		funcionario.setLogin("marcos");
		funcionario.setSenha("12345");
		funcionario.setEmail("marcos@msgas.com.br");
		funcionariodao.cadastrar(funcionario);
		
		List<Funcionario> lista = new ArrayList<Funcionario>();
		
		lista = funcionariodao.getLista();
		
		System.out.println("-------------------------------------");
		
		for (Funcionario funcionario1 : lista) {
			System.out.println(funcionario1.getMatricula());
			System.out.println(funcionario1.getCpf());
			System.out.println(funcionario1.getPis());
			System.out.println(funcionario1.getNome());
			System.out.println(funcionario1.getDepto().getNome());
			System.out.println(funcionario1.getChefe().getNome());
			System.out.println(funcionario1.getLogin());
			System.out.println(funcionario1.getSenha());
			System.out.println(funcionario1.getEmail());
			System.out.println("-------------------------------------");
		}
		
		
		
		
		
		
	}

}
