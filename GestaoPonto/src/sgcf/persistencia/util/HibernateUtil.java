package sgcf.persistencia.util;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory fabrica;
	
	static{
		//Objeto de configuracao
		AnnotationConfiguration config= new AnnotationConfiguration();
		
		//Lemos o arquivo xml e transforma em objeto configuration
		Configuration arquivoconfig= config.configure("hibernate.cfg.xml");
		
		//Construimos uma fabrica de sessao através do objeto 
		//obtido do arquivo xml
		fabrica = arquivoconfig.buildSessionFactory();
	}
	
	public static Session abrirSessao()
	{
		return fabrica.openSession();
	}
	
}
