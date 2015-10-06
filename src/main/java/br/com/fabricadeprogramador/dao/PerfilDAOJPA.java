package br.com.fabricadeprogramador.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.fabricadeprogramador.entidade.Perfil;

@Repository
public class PerfilDAOJPA implements PerfilDAO {
	// Dependencia
	@PersistenceContext
	EntityManager em;

	public PerfilDAOJPA(EntityManager em) {
		this.em = em;
	}

	public PerfilDAOJPA() {

	}

	@Transactional
	
	public Perfil salvar(Perfil perfil) {
		Perfil u = em.merge(perfil);
		return u;

	}
	

	/*
	 * @Transactional public void excluir(Perfil perfil) {
	 * 
	 * em.remove(perfil);
	 * 
	 * }
	 */ 

	@Transactional
	//begin()
	public void excluir(Perfil perfil) throws DAOException {
		try {
			
			Perfil usuManaged = em.getReference(Perfil.class, perfil.getId());
			em.remove(usuManaged);
		} catch (Exception e) {
			throw new DAOException("Não foi possivel Excluir!", e);
		}
	}
	//commit()
	public Perfil buscarPorId(int id) {
		return em.find(Perfil.class, id);
	}

	public List<Perfil> buscarTodos() {
		Query q = em.createQuery("select u from Perfil u");
		return q.getResultList();
	}

	

}
