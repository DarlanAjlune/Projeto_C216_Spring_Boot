package br.inatel.labs.labjpa.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;

@Service
@Transactional
public class NotaCompraService {

	
	@PersistenceContext
	private EntityManager em;
	
	//1.Nota Compra
	public NotaCompra salvarNotaCompra(NotaCompra nc) {
		nc = em.merge(nc);
		return nc;
	}
	
	public NotaCompra buscarNotaCompraPeloId(Long id) {
		NotaCompra nc = em.find(NotaCompra.class, id);
		return nc;
	}
	
	public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id) {
		NotaCompra nota = em.find(NotaCompra.class, id);
		nota.getListaNotaCompraItem().size(); // Provocando o Proxy para buscar a lista de itens
		return nota;
	}
	
	public List<NotaCompra> listaNotaCompra(){
		List<NotaCompra> notas = em.createQuery("select n from NotaCompra n", NotaCompra.class).getResultList();
		return notas;
	}
	
	//2. Nota Compra Item
	public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item) {
		item = em.merge(item);
		return item;
	}
	
	public NotaCompraItem buscarNotaCompraItemPeloId(Long id) {
		NotaCompraItem item = em.find(NotaCompraItem.class, id);
		return item;
	}
	
	public List<NotaCompraItem> listaNotaCompraItem(){
		List<NotaCompraItem> itens = em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class).getResultList();
		return itens;
	}
	
	
}
