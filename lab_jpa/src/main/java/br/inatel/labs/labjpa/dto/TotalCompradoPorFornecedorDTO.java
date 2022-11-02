package br.inatel.labs.labjpa.dto;

import java.math.BigDecimal;

public class TotalCompradoPorFornecedorDTO {

	private final String fornecedorRazaoSocial;
	private final BigDecimal totalComprado;
	
	public TotalCompradoPorFornecedorDTO(String fornecedorRazaoSocial, BigDecimal totalComprado) {
		this.fornecedorRazaoSocial = fornecedorRazaoSocial;
		this.totalComprado = totalComprado;
	}

	public String getFornecedorRazaoSocial() {
		return fornecedorRazaoSocial;
	}

	public BigDecimal getTotalComprado() {
		return totalComprado;
	}

	@Override
	public String toString() {
		return "TotalCompradoPorFornecedorDTO [fornecedorRazaoSocial=" + fornecedorRazaoSocial + ", totalComprado="
				+ totalComprado + "]";
	}
	
	
}
