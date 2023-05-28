package aula.engenharia.demo.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import aula.engenharia.demo.dto.AlunoDTO;
import aula.engenharia.demo.form.AlunoForm;
import aula.engenharia.demo.model.Aluno;
import aula.engenharia.demo.repository.AlunoRepository;

@RestController
@CrossOrigin
@RequestMapping("/alunos")
public class AlunoController {
	
	@Autowired
	private AlunoRepository alunoRepository;
	
	@GetMapping
	public List<AlunoDTO> lista() {
		List<Aluno> alunos = alunoRepository.findAll();
		return AlunoDTO.converter(alunos);
	}
	
	@PostMapping
	public ResponseEntity<AlunoDTO> cadastrar(@RequestBody AlunoForm form, UriComponentsBuilder uriBuilder) {
		Aluno aluno = form.converter(alunoRepository);
		alunoRepository.save(aluno);
		
		URI uri = uriBuilder.path("/alunos/{ra}").buildAndExpand(aluno.getRa()).toUri();
		return ResponseEntity.created(uri).body(new AlunoDTO(aluno));
	}
}

