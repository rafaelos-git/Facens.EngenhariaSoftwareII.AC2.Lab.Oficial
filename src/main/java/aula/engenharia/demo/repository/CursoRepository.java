package aula.engenharia.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import aula.engenharia.demo.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long>{
    
}
