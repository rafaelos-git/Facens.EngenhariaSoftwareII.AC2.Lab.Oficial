package aula.engenharia.demo.form;

import aula.engenharia.demo.model.Curso;
import aula.engenharia.demo.repository.CursoRepository;

public class CursoForm {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Curso converter(CursoRepository CursoRepository) {
		return new Curso(nome);
	}
}
