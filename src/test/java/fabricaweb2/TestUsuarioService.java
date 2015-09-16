package fabricaweb2;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "file:src/main/resources/META-INF/springbeans.xml")
@TransactionConfiguration(defaultRollback = true)
public class TestUsuarioService {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	@Qualifier("usuarioDAOJPA")
	UsuarioDAO usuarioDAO;

	@Test (expected=ServiceException.class)
	public void testNaoDeveSalvar() throws ServiceException {
		Usuario usu = new Usuario();
		usu.setLogin("testsalvar2");
		usu.setSenha("123");
		usu.setSenha("Test Nome");

		usuarioDAO.salvar(usu);
		
		usuarioService.salvar(usu);

	}

	public void testDeveSalvar() {

	}

}
