package br.com.fabricadeprogramador.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.fabricadeprogramador.entidade.Usuario;
import br.com.fabricadeprogramador.service.ServiceException;
import br.com.fabricadeprogramador.service.UsuarioService;

@Controller(value="usuCtrl")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	private Usuario usuario =  new Usuario();
	private List<Usuario> usuarioList ;
	
	public UsuarioController() {
		
	}
	//Busca feita após o construtor já com a injeção de dependencia do usuarioService
	@PostConstruct
	public void init(){
		setUsuarioList(usuarioService.buscarTodos());
	} 
	
	public void excluir(Usuario usuario){
		try {
			usuarioService.excluir(usuario);
			usuarioList.remove(usuario);
			MensagemUtil.mensagemAviso(MensagemUtil.EXCLUIDO_SUCESSO);
		
		} catch (ServiceException e) {
			
			MensagemUtil.mensagemErro(MensagemUtil.FALHA_EXCLUSAO);
			e.printStackTrace();
		}
	}
	
	public void editar(Usuario usuario){
		this.usuario=usuario;
	}
	
	public void cancelar(){
		this.usuario= new Usuario();
	}
	public void salvar(){
		try {
			Usuario usuSalvo = usuarioService.salvar(usuario);
			if(usuario.getId()==null)
			usuarioList.add(usuSalvo);
			
			//Limpa o form
			usuario= new Usuario();
			MensagemUtil.mensagemAviso(MensagemUtil.SALVO_SUCESSO);
		} catch (ServiceException e) {
			MensagemUtil.mensagemAviso(MensagemUtil.FALHA_SALVAR);
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

	public List<Usuario> getUsuarioList() {
		return usuarioList;
	}

	public void setUsuarioList(List<Usuario> usuarioList) {
		this.usuarioList = usuarioList;
	}
	
}
