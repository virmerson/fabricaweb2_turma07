package br.com.fabricadeprogramador.controller;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.fabricadeprogramador.entidade.Perfil;
import br.com.fabricadeprogramador.service.PerfilService;

@Component
public class PerfilConverter implements Converter {

	@Autowired
	PerfilService perfilService;

	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String idTela) {
		try {
			return perfilService.buscarPorId(Integer.parseInt(idTela));
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object objPerfil) {
		try {
			Perfil p = (Perfil) objPerfil;
			return p.getId().toString();
		} catch (Exception e) {
			return null;
		}
	}

}
