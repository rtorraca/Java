package sgcf.teste;

import java.util.ArrayList;
import java.util.List;

import sgcf.persistencia.dao.FeriasDAO;
import sgcf.persistencia.dao.ParcelaDAO;
import sgcf.persistencia.entidade.Ferias;
import sgcf.persistencia.entidade.Parcela;

public class TesteParcelaDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParcelaDAO parceladao = new ParcelaDAO();
		
		
		
		List<Parcela> lista = new ArrayList<Parcela>();
		Ferias ferias = new FeriasDAO().getPorId(1);
		
		lista = parceladao.getListaPorFerias(ferias);
		
		for (Parcela parcela : lista) {
			//System.out.println("Ferias:"+ parcela.getFerias().getId());
			System.out.println("Id:"+parcela.getId().toString());
			System.out.println("Inicio:"+parcela.getData_ini().toString());
			System.out.println("Fim:"+parcela.getData_fim().toString());
			
		}
	}

}
