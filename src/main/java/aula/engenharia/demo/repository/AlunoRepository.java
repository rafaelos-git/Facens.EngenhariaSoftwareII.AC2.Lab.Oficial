package aula.engenharia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aula.engenharia.demo.model.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, Long>{
    
}
