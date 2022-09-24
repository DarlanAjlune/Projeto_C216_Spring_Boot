package br.inatel.labs.labrest.server.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.web.reactive.server.WebTestClient;

import br.inatel.labs.labrest.server.model.Curso;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class CursoControllerTest {
	
	@Autowired
	private WebTestClient webTestClient;

	@Test
	void deveListarCursos() {
		webTestClient.get()
			.uri("/curso")
			.exchange()
			.expectStatus().isOk()
			.expectBody().returnResult();
	}
	
	@Test
	void dadoCursoIdValido_quandoGetCursoPeloId_entaoRespondeComCursoValido() {
		Long cursoIdValido = 1L;
		Curso cursoRespondido = webTestClient.get()
			.uri("/curso/" + cursoIdValido)
			.exchange()
			.expectStatus().isOk()
			.expectBody(Curso.class).returnResult().getResponseBody();
		
		assertNotNull(cursoRespondido);
		assertEquals(cursoRespondido.getId(), cursoIdValido);
	}
	
	@Test
	void dadoCursoIdInvalido_quandoGetCursoPeloId_entaoRespondeComStatusNotFound() {
		
		Long cursoIdInvalido = -1L;
		
		webTestClient.get()
			.uri("/curso/" + cursoIdInvalido)
			.exchange()
			.expectStatus().isNotFound();
	}
	
	@Test
	void dadoNovoCurso_quandoPostCurso_entaoRespondeComStatusCreatedECursoValido() {
		Curso novoCurso = new Curso();
		novoCurso.setDescricao("Testando REST com Spring WebFlux");
		novoCurso.setCargaHoraria(120);
		
		Curso cursoRespondido = webTestClient.post()
			.uri("/curso")
			.bodyValue(novoCurso)
			.exchange()
			.expectStatus().isCreated()
			.expectBody(Curso.class).returnResult().getResponseBody();
				
		assertThat(cursoRespondido).isNotNull();
		assertThat(cursoRespondido.getId()).isNotNull();
		
	}
	
	@Test
	void dadoAtualizarCurso_quandoPutCurso_entaoRespondeComStatusNoContentECorpoVazio() {
		
		Long cursoIdValido = 1L;
		Curso novoCurso = new Curso();
		novoCurso.setDescricao("Testando metodo de atualizar curso");
		novoCurso.setCargaHoraria(0);
		novoCurso.setId(cursoIdValido);
		
		webTestClient.put()
			.uri("/curso")
			.bodyValue(novoCurso)
			.exchange()
			.expectStatus().isNoContent()
			.expectBody().isEmpty();
	}
	
	@Test
	void dadoDeleteCursoIdValido_quandoDeleteCurso_entaoRespondeComStatusNoContentECorpoVazio() {
		Long cursoIdValido = 2L;
		webTestClient.delete()
			.uri("/curso/" + cursoIdValido)
			.exchange()
			.expectStatus().isNoContent()
			.expectBody().isEmpty();
		
	}
	
	@Test
	void dadoDeleteCursoIdInvalido_quandoDeleteCurso_entaoRespondeComStatusNotFound() {
		Long cursoIdValido = -1L;
		webTestClient.delete()
			.uri("/curso/" + cursoIdValido)
			.exchange()
			.expectStatus().isNotFound();
	}
	
}
