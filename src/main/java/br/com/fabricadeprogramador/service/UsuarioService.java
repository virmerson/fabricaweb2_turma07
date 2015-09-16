package br.com.fabricadeprogramador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.dao.UsuarioDAO;
import br.com.fabricadeprogramador.entidade.Usuario;


@Service
public class UsuarioService {
	
	@Autowired
	@Qualifier(value="usuarioDAOJPA")
	UsuarioDAO usuarioDAO;
	
	@Transactional
	public Usuario salvar(Usuario usuario) throws ServiceException{
		//verificacoes
		Usuario usuarioExistente = usuarioDAO.buscarLogin(usuario.getLogin());
		//Já existe
		if (usuarioExistente!=null){
			throw new ServiceException("Usuário Já Existe!");
		}
		return usuarioDAO.salvar(usuario);
	}
}