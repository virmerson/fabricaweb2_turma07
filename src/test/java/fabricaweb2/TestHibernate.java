package fabricaweb2;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.fabricadeprogramador.entidade.Usuario;

public class TestHibernate {

	public static void main(String[] args) {
		//Fabrica de EntityManager
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("fabricaweb2");
		
		//Gerenciador de Entidades
		EntityManager em = emf.createEntityManager();
		
		//Criando objeto a ser persistido
		Usuario usu = new Usuario();
		usu.setNome("Jão");
		usu.setLogin("j");
		usu.setSenha("123");
		//Iniciando transacao 
		em.getTransaction().begin();
		//Prepara a Instrucao SQL
		em.persist(usu);
		//Confirmando transacao, Fazendo a pesistencia no banco
		em.getTransaction().commit();
	}

}
