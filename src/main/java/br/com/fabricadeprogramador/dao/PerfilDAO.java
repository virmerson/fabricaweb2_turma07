package br.com.fabricadeprogramador.dao;

import java.util.List;

import br.com.fabricadeprogramador.entidade.Perfil;

public interface PerfilDAO {

	public Perfil salvar (Perfil perfil);
	
	public void excluir(Perfil perfil) throws DAOException;
	
	public Perfil buscarPorId(int id);
	
	public List<Perfil> buscarTodos ();

	
	
}
