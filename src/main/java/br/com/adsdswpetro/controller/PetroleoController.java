package br.com.adsdswpetro.controller;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.context.RequestContext;

import br.com.adsdswpetro.model.Petroleo;
import br.com.adsdswpetro.model.TipoPetroleo;
import br.com.adsdswpetro.repository.Petroleos;
import br.com.adsdswpetro.service.PetroleoService;
import br.com.adsdswpetro.util.FacesMessages;

@Named
@ViewScoped
public class PetroleoController implements Serializable {
	private static final long serialVersionUID = 1L;

	@Inject
	private Petroleos empresas;
	
	@Inject
	private PetroleoService empresaService;
	
	@Inject
	private FacesMessages messages;
	
	private List<Petroleo> listEmpresa;
	private Petroleo empresaEdicao = new Petroleo();
	private Petroleo empresaSelecionada;
	
	public void novaEmpresa() {
		empresaEdicao = new Petroleo();
	}

	public void salvar() {
		empresaService.salvar(empresaEdicao);
		carregaEmpresas();
		messages.info("Empresa salva com sucesso!");
		RequestContext.getCurrentInstance().update(Arrays.asList("frm:msgs", "frm:empresas-table"));
	}
	
	public void excluir() {
		empresaService.excluir(empresaSelecionada);
		empresaSelecionada = null;
		carregaEmpresas();
		messages.info("Empresa excluída com sucesso!");
	}
	
	public void carregaEmpresas() {
 		listEmpresa = empresas.todas();
	}

	public List<Petroleo> getTodasEmpresas() {
		return listEmpresa;
	}
	
	public TipoPetroleo[] getTiposEmpresas() {
		return TipoPetroleo.values();
	}

	public Petroleo getEmpresaEdicao() {
		return empresaEdicao;
	}

	public void setEmpresaEdicao(Petroleo empresaEdicao) {
		this.empresaEdicao = empresaEdicao;
	}

	public Petroleo getEmpresaSelecionada() {
		return empresaSelecionada;
	}

	public void setEmpresaSelecionada(Petroleo empresaSelecionada) {
		this.empresaSelecionada = empresaSelecionada;
	}
	
}