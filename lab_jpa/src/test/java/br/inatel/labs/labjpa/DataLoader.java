package br.inatel.labs.labjpa;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.inatel.labs.labjpa.entity.Fornecedor;
import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.service.FornecedorService;
import br.inatel.labs.labjpa.service.NotaCompraService;
import br.inatel.labs.labjpa.service.ProdutoService;

//@SpringBootTest
class DataLoader {

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private FornecedorService fornecedorService;
	
	@Autowired
	private NotaCompraService notaCompraService;
	
	//@Test
	void load() {
	
		//1.produto
		Produto p1 = new Produto("Furadeira");
		Produto p2 = new Produto("Lixadeira");
		Produto p3 = new Produto("Plaina");
		Produto p4 = new Produto("Tupia");
		Produto p5 = new Produto("Serra Circular");
		
		p1 = produtoService.salvar(p1);
		p2 = produtoService.salvar(p2);
		p3 = produtoService.salvar(p3);
		p4 = produtoService.salvar(p4);
		p5 = produtoService.salvar(p5);
		
		List<Produto> lista = produtoService.listar();
		lista.forEach(System.out::println);
		
		//2.fornecedor
		Fornecedor f1 = new Fornecedor("Gasometro Madeiras");
		Fornecedor f2 = new Fornecedor("Loja do Mecânico");
		
		f1 = fornecedorService.salvar(f1);
		f2 = fornecedorService.salvar(f2);
		
		List<Fornecedor> listaDeFornecedores = fornecedorService.listar();
		listaDeFornecedores.forEach(System.out::println);
	
		//3.nota compra
		NotaCompra nc1 = new NotaCompra(LocalDate.of(2021, 1, 15), f1);
		nc1 = notaCompraService.salvarNotaCompra(nc1);
		
		NotaCompra nc2 = new NotaCompra(LocalDate.of(2022, 2, 20), f2);
		nc2 = notaCompraService.salvarNotaCompra(nc2);
		
		notaCompraService.listaNotaCompra().forEach(System.out::println);
		
		//4.nota compra item
		NotaCompraItem i1_1 = new NotaCompraItem(nc1, p1, new BigDecimal("300.00"), 2);
		NotaCompraItem i1_2 = new NotaCompraItem(nc1, p2, new BigDecimal("1000.00"), 1);
		NotaCompraItem i1_3 = new NotaCompraItem(nc1, p3, new BigDecimal("500.00"), 3);
		i1_1 = notaCompraService.salvarNotaCompraItem(i1_1);
		i1_2 = notaCompraService.salvarNotaCompraItem(i1_2);
		i1_3 = notaCompraService.salvarNotaCompraItem(i1_3);
		
		NotaCompraItem i2_1 = new NotaCompraItem(nc2, p4, new BigDecimal("400.00"), 7);
		NotaCompraItem i2_2 = new NotaCompraItem(nc2, p2, new BigDecimal("1000.00"), 2);
		NotaCompraItem i2_3 = new NotaCompraItem(nc2, p5, new BigDecimal("700.00"), 1);
		i2_1 = notaCompraService.salvarNotaCompraItem(i2_1);
		i2_2 = notaCompraService.salvarNotaCompraItem(i2_2);
		i2_3 = notaCompraService.salvarNotaCompraItem(i2_3);
		
		notaCompraService.listaNotaCompraItem().forEach(System.out::println);
		
	}

}
