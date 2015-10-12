package br.com.fabricadeprogramador.converter;

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
			Perfil p=  perfilService.buscarPorId(Integer.parseInt(idTela));
			return p;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1,
			Object objPerfil) {
		try {
			if (objPerfil instanceof Perfil){
				Perfil p = (Perfil) objPerfil;
				return p.getId().toString();
			}
			return null;
		} catch (Exception e) {
			return null;
		}
	}

}
