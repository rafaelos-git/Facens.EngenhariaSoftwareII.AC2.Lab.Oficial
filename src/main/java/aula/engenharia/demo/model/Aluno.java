package aula.engenharia.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Aluno {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String ra;
	private String nome;
	private String email;
	private String senha;
	@OneToMany
	private List<Curso> cursos;

	public Aluno(){

	}

	public Aluno(String nome) {
		this.nome = nome;
		this.cursos = new ArrayList<Curso>();
	}

	public Aluno(String nome, String ra, String email, String senha) {
		this.nome = nome;
		this.ra = ra;
		this.email = email;
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public void cursosLiberados(Curso curso) {
		if(cursos.isEmpty() || !cursos.get(ultimoCursoVisto()).getNome().equals(curso.getNome())) {
			this.cursos.add(curso);
		}
	}

	private int ultimoCursoVisto() {
		return cursos.size()-1;
	}

	public List<Curso> getCursosLiberados() {
		return cursos;
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

	public void cursoFinalizado(Curso curso) {
		if (curso.getMedia() >= 7) {
			cursosLiberados(new Curso(curso.getNome() + " - " + "Complementar 1"));
			cursosLiberados(new Curso(curso.getNome() + " - " + "Complementar 2"));
			cursosLiberados(new Curso(curso.getNome() + " - " + "Complementar 3"));
		}
		curso.finalizarCurso();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((cursos == null) ? 0 : cursos.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aluno other = (Aluno) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (cursos == null) {
			if (other.cursos != null)
				return false;
		} else if (!cursos.equals(other.cursos))
			return false;
		return true;
	}
}
