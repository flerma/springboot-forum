package br.com.alura.forum.repository;

import br.com.alura.forum.modelo.Curso;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@ActiveProfiles("test")
class CursoRepositorySemH2Test {

    @Autowired
    private CursoRepository repository;

    @Autowired
    private TestEntityManager em;

    @Test
    void deveriaCarregarUmCursoAoBuscarPeloNomeTest() {
        String nomeCurso = "HTML 5";

        Curso html5 = new Curso();
        html5.setNome(nomeCurso);
        html5.setCategoria("Programa√ß√£o");
        em.persist(html5);

        Curso curso = repository.findByNome(nomeCurso);
        assertNotNull(curso);
        assertEquals(nomeCurso, curso.getNome());
    }

    @Test
    void naoDeveriaCarregarUmCursoCujoNomeN√£oEstaCadastradoTest() {
        String nomeCurso = "JPA";
        Curso curso = repository.findByNome(nomeCurso);
        assertNull(curso);
    }
}