package br.inatel.labs.labrest.server.model;

import java.util.Objects;

public class Curso {
	private Long id;
	private String descricao;
	private Integer cargaHoraria;
	
	// Construtores 
	
	public Curso(Long id, String descricao, Integer cargaHoraria) {
		super();
		this.id = id;
		this.descricao = descricao;
		this.cargaHoraria = cargaHoraria;
	}
	
	public Curso() {
	}

	// Assessores
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Integer getCargaHoraria() {
		return cargaHoraria;
	}

	public void setCargaHoraria(Integer cargaHoraria) {
		this.cargaHoraria = cargaHoraria;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Curso other = (Curso) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Curso [id=" + id + ", descricao=" + descricao + ", cargaHoraria=" + cargaHoraria + "]";
	}
	
	
	
	
}
