package br.com.adsdswpetro.service;

import java.io.Serializable;

import javax.inject.Inject;

import br.com.adsdswpetro.model.Petroleo;
import br.com.adsdswpetro.repository.Petroleos;
import br.com.adsdswpetro.util.Transacional;

public class PetroleoService implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private Petroleos empresas;
	
	@Transacional
	public void salvar(Petroleo empresa) {
		empresas.salvar(empresa);
	}
	
	@Transacional
	public void excluir(Petroleo empresa) {
		empresas.excluir(empresa);
	}
}
