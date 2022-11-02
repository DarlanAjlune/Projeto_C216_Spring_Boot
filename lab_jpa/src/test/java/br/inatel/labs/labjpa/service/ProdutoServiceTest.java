package br.inatel.labs.labjpa.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import br.inatel.labs.labjpa.entity.Produto;

@SpringBootTest
@ActiveProfiles("test")
class ProdutoServiceTest {

	@Autowired
	private ProdutoService produtoService;
	
	@Test
	void dadoIdValido_quandoInvocaBuscarPeloId_entaoProdutoRetornadoEhValido() {
		Long idValido = 1L;
		Produto produtoEncontrado = produtoService.buscarPeloId(idValido);
		
		assertFalse(produtoEncontrado == null);
		assertFalse(produtoEncontrado.getDescricao().isBlank());
		
		assertEquals(idValido, produtoEncontrado.getId());
	}

}
