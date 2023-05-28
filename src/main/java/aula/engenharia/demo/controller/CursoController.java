package aula.engenharia.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import aula.engenharia.demo.dto.CursoDTO;
import aula.engenharia.demo.form.CursoForm;
import aula.engenharia.demo.model.Curso;
import aula.engenharia.demo.repository.CursoRepository;

@RestController
@RequestMapping("/cursos")
public class CursoController {
    
    @Autowired
	private CursoRepository cursoRepository;
	
	@GetMapping
	public List<CursoDTO> lista() {
		List<Curso> cursos = cursoRepository.findAll();
		return CursoDTO.converter(cursos);
	}
	
	@PostMapping
	public ResponseEntity<CursoDTO> cadastrar(@RequestBody CursoForm form, UriComponentsBuilder uriBuilder) {
		Curso curso = form.converter(cursoRepository);
		cursoRepository.save(curso);
		
		URI uri = uriBuilder.path("/cursos/{codigo}").buildAndExpand(curso.getCodigo()).toUri();
		return ResponseEntity.created(uri).body(new CursoDTO(curso));
	}
}
