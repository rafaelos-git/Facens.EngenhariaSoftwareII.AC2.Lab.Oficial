package aula.engenharia.demo.service;

import aula.engenharia.demo.model.Aluno;
import aula.engenharia.demo.model.Curso;

public class ControleCursos {
    public void verificaCurso(Aluno aluno, Curso cursoTerminado) {
        boolean verificado = false;
        for (Curso curso : aluno.getCursos()) {
            if(curso.getNome() == cursoTerminado.getNome()) {
                verificado = true;
            }
        }

        if(verificado) {
            aluno.cursoFinalizado(cursoTerminado);
        }
    }
}
