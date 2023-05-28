package aula.engenharia.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import aula.engenharia.demo.model.Curso;

public class CursoDTO {
    private String nome;

    public CursoDTO(Curso curso) {
		super();
		this.nome = curso.getNome();
	}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public static List<CursoDTO> converter(List<Curso> usuarios) {
		return usuarios.stream().map(CursoDTO::new).collect(Collectors.toList());
	}
}
