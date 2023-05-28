package aula.engenharia.demo.form;

import aula.engenharia.demo.model.Aluno;
import aula.engenharia.demo.repository.AlunoRepository;

public class AlunoForm {
    private String nome;
    private String ra;
    private String email;
    private String senha;

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRa() {
        return ra;
    }
    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Aluno converter(AlunoRepository AlunoRepository) {
		return new Aluno(nome, ra, email, senha);
	}
}
