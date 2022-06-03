package br.com.adsdswpetro.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.com.adsdswpetro.model.Petroleo;

public class Petroleos implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Petroleo porId(Long id) {
		return manager.find(Petroleo.class, id);
	}
	
	public List<Petroleo> todas() {
		return manager.createQuery("from Petroleo", Petroleo.class).getResultList();
	}
	
	public Petroleo salvar(Petroleo empresa) {
		return manager.merge(empresa);
	}
	
	public void excluir(Petroleo empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}
}
