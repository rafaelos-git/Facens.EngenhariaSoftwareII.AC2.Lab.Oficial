package aula.engenharia.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import aula.engenharia.demo.model.Aluno;

public class AlunoDTO {
    private String ra;
    private String nome;
    private String email;

    public AlunoDTO(Aluno aluno) {
		super();
		this.ra = aluno.getRa();
		this.nome = aluno.getNome();
		this.email = aluno.getEmail();
	}

    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public static List<AlunoDTO> converter(List<Aluno> usuarios) {
		return usuarios.stream().map(AlunoDTO::new).collect(Collectors.toList());
	}
}
