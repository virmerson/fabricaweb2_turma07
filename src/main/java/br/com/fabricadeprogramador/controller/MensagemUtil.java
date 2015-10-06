package br.com.fabricadeprogramador.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class MensagemUtil {
	
	public static final String EXCLUIDO_SUCESSO = "Excluído Com Sucesso!";
	public static final String FALHA_EXCLUSAO = "Não pode ser excluido!";
	public static final String SALVO_SUCESSO = "Salvo com Sucesso!";
	public static final String FALHA_SALVAR = "Falha ao Salvar!";

	public static void mensagemInfo (String mensagem){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem,null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	public static void mensagemErro (String mensagem){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem,null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}
	
	public static void mensagemAviso (String mensagem){
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem,null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
		
	}

}
