package br.com.adsdswpetro.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CNPJ;

@Entity
public class Petroleo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id 
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;

	@NotEmpty
	@Column(name = "pais", nullable = false, length = 80)
	private String pais;

	@NotEmpty
	@Column(name = "razao_social", nullable = false, length = 120)
	private String razaoSocial;

	@NotEmpty
	@CNPJ
	@Column(nullable = false, length = 18)
	private String cnpj;
	
	@NotEmpty
	@Column(name="marca_revenda", nullable = false, length = 18)
	private String marca;
	
	@Digits(integer = 3, fraction = 2, message="Apenas 2 centenas e 2 casas ap�s o ponto.")
	private BigDecimal preco;

	@NotNull
	@Past
	@Temporal(TemporalType.DATE)
	@Column(name = "data_fundacao")
	private Date dataFundacao;

	@NotNull
	@Enumerated(EnumType.STRING)
	private TipoPetroleo tipo;
	


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}



	public BigDecimal getPreco() {
		return preco;
	}

	public void setPreco(BigDecimal preco) {
		this.preco = preco;
	}

	public Date getDataFundacao() {
		return dataFundacao;
	}

	public void setDataFundacao(Date dataFundacao) {
		this.dataFundacao = dataFundacao;
	}

	public TipoPetroleo getTipo() {
		return tipo;
	}

	public void setTipo(TipoPetroleo tipo) {
		this.tipo = tipo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Petroleo other = (Petroleo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}