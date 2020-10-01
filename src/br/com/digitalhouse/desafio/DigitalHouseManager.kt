package br.com.digitalhouse.desafio

import br.com.digitalhouse.desafio.exceptions.*

class DigitalHouseManager() {
    val alunos = mutableSetOf<Aluno>()
    val professores = mutableSetOf<Professor>()
    val cursos = mutableSetOf<Curso>()
    val matriculas = mutableSetOf<Matricula>()

    fun registrarCurso(nome: String, codigo: Int, qtdMaxAlunos: Int) {
        if (!cursos.add(Curso(codigo, nome, qtdMaxAlunos)))
            throw CursoExistenteException()
    }

    fun excluirCurso(codigo: Int) {
        val curso = cursos.find { it.codigo == codigo } ?: throw CursoNaoEncontradoException()
        cursos.remove(curso)
    }

    fun registrarProfessorAdjunto(nome: String,
                                  sobrenome: String,
                                  codigo: Int,
                                  horasMonitoria: Int) {
        if (!professores.add(ProfessorAdjunto(
                        codigo,
                        nome,
                        sobrenome,
                        0,
                        horasMonitoria)))
            throw ProfessorExistenteException()
    }

    fun registrarProfessorTituar(nome: String,
                                 sobrenome: String,
                                 codigo: Int,
                                 especialidade: String) {
        if (!professores.add(ProfessorTitular(
                        codigo,
                        nome,
                        sobrenome,
                        0,
                        especialidade)))
            throw ProfessorExistenteException()
    }

    fun excluirProfessor(codigo: Int) {
        var prof = professores.find { it.codigo == codigo } ?: throw ProfessorNaoEncontradoException()
        professores.remove(prof)
    }

    fun matricularAluno(nome: String, sobrenome: String, codigo: Int) {
        if (!alunos.add(Aluno(codigo, nome, sobrenome)))
            throw AlunoExistenteException()
    }

    fun matricularAluno(codigoAluno: Int, codigoCurso: Int) {
        val aluno = alunos.find { it.codigo == codigoAluno } ?: throw AlunoNaoEncontradoException()
        val curso = cursos.find { it.codigo == codigoCurso } ?: throw CursoNaoEncontradoException()

        if (curso.qtdMaxAlunos >= curso.alunos.size)
            throw SemVagasException()

        if (!matriculas.add(Matricula(matriculas.size+1, aluno, curso)))
            throw MatriculaExistenteException()
    }

    fun alocarProfessores(codigoCurso: Int,
                          codigoProfTitular: Int,
                          codigoProfAdjunto: Int) {
        val curso = cursos.find { it.codigo == codigoCurso } ?: throw CursoNaoEncontradoException()
        var profAdjunto = professores.find { it.codigo == codigoProfAdjunto && it is ProfessorAdjunto }
                ?: throw ProfessorNaoEncontradoException()
        val profTitular = professores.find { it.codigo == codigoProfTitular && it is ProfessorTitular }
                ?: throw ProfessorNaoEncontradoException()

        curso.profAdjunto = profAdjunto as? ProfessorAdjunto
        curso.profTitular = profTitular as? ProfessorTitular
    }


}