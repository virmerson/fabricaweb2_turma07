package br.com.fabricadeprogramador.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;



@Controller(value="usuCtrl")
public class UsuarioController {

	private Usuario usuario =  new Usuario();
	
	@Autowired
	private UsuarioService usuarioService;
	
	public void salvar(){
		try {
			usuarioService.salvar(usuario);
			System.out.println("SUCESSO!");
		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	//Getters and Setters
	public Usuario getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
