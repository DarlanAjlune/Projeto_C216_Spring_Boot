package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.Fornecedor;

@Service
@Transactional
public class FornecedorService {

	@PersistenceContext
	private EntityManager em;
	
	public Fornecedor salvar(Fornecedor f) {
		f = em.merge(f);
		return f;
	}
	
	public Fornecedor buscarPeloId(Long id) {
		Fornecedor fornecedor = em.find(Fornecedor.class, id);
		return fornecedor;
	}
	
	public List<Fornecedor> listar(){
		List<Fornecedor> listaFornecedor = em.createQuery("select f from Fornecedor f", Fornecedor.class)
				.getResultList();
		return listaFornecedor;
	}
	
	public void remover(Fornecedor f) {
		f = em.merge(f);
		em.remove(f);
	}
}
