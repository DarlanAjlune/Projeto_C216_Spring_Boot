package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;

@Service
public class RelatorioService {

	@PersistenceContext
	private EntityManager em;
	
	public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
		String query 
		= " select new br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO "
		+ "		(f.razaoSocial "
		+ "		, sum( i.quantidade * i.valorCompraProduto)"
		+ "		) "
		+ " from NotaCompraItem i "
		+ "		join i.notaCompra n "
		+ "		join n.fornecedor f "
		+ " group by f.razaoSocial "
		;
		
		return em.createQuery(query, TotalCompradoPorFornecedorDTO.class).getResultList();
	}
}
