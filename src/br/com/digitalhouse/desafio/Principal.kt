package br.com.digitalhouse.desafio

import br.com.digitalhouse.desafio.exceptions.*
import br.com.digitalhouse.desafio.util.toFormatBrazil

fun main() {

    var codigo = 0
    var codigoProfTit = 0
    var codigoProfAdj = 0
    var codigoCurso = 0
    try {
        // Registro de dois Professores Titulares
        codigo = 1
        DigitalHouseManager.registrarProfessorTituar("João", "da Silva", codigo, "HTML, CSS e JS")
        codigo = 2
        DigitalHouseManager.registrarProfessorTituar("Mario", "dos Santos", codigo, "Angular")

        // Registro de dois Professores Adjunto
        codigo = 3
        DigitalHouseManager.registrarProfessorAdjunto("Maria", "da Silva", codigo, 20)
        codigo = 4
        DigitalHouseManager.registrarProfessorAdjunto("Vitoria", "dos Santos", codigo, 3)

        // Registro de dois Cursos
        codigo = 20001
        DigitalHouseManager.registrarCurso("Full Stack", codigo, 3)
        codigo = 20002
        DigitalHouseManager.registrarCurso("Android", codigo, 2)

        // Alocação de um professsor titular e um adjunto para cada curso.
        codigo = 20001
        codigoProfTit = 1
        codigoProfAdj = 3
        DigitalHouseManager.alocarProfessores(codigo, codigoProfTit, codigoProfAdj)
        codigo = 20002
        codigoProfTit = 2
        codigoProfAdj = 4
        DigitalHouseManager.alocarProfessores(codigo, codigoProfTit, codigoProfAdj)

        // Matricula de 3 alunos na escola
        codigo = 1
        DigitalHouseManager.matricularAluno("Victor", "Rubens", codigo)
        codigo = 2
        DigitalHouseManager.matricularAluno("Matheus", "Ferreira", codigo)
        codigo = 3
        DigitalHouseManager.matricularAluno("Murilo", "Pereira", codigo)


        // Matricula dois alunos no curso de FullStack
        codigo = 1
        codigoCurso = 20001
        DigitalHouseManager.matricularAluno(codigo, codigoCurso)
        codigo = 2
        DigitalHouseManager.matricularAluno(codigo, codigoCurso)

        // Matricular três alunos no curso de Android
        codigo = 1
        codigoCurso = 20002
        DigitalHouseManager.matricularAluno(codigo, codigoCurso)
        codigo = 2
        DigitalHouseManager.matricularAluno(codigo, codigoCurso)
        try {
            codigo = 3
            DigitalHouseManager.matricularAluno(codigo, codigoCurso)
        } catch (e: SemVagasException) {
            println("Não há vagas no curso de código $codigoCurso")
        }

        // Parte K - Buscar Matriculas por Aluno
        codigo = 1
        val matriculas = DigitalHouseManager.consultarMatriculas(codigo)
        if (matriculas.isNotEmpty()) {
            val aluno = matriculas[0].aluno
            println("\nMatriculas do aluno ${aluno.nome} ${aluno.sobrenome}")
            matriculas.forEach { println("Código: ${it.codigo} - Curso: ${it.curso.nome} - Data: ${it.dtMatricula.toFormatBrazil()}") }
        }
    } catch (e: ProfessorExistenteException) {
        println("O professor de código $codigo já está cadastrado.")
    } catch (e: CursoExistenteException) {
        println("O curso de código $codigo já está cadastrado.")
    } catch (e: AlunoExistenteException) {
        println("O aluno de código $codigo já está cadastrado.")
    } catch (e: MatriculaExistenteException) {
        println("O matricula já está cadastrado.")
    } catch (e: CursoNaoEncontradoException) {
        println("O curso de código $codigo não foi encontrado!")
    } catch (e: ProfessorTitularNaoEncontradoException) {
        println("O professor titular de código $codigoProfTit não foi encontrado!")
    } catch (e: ProfessorAdjuntoNaoEncontradoException) {
        println("O professor adjunto de código $codigoProfAdj não foi encontrado!")
    } catch (e: SemVagasException) {
        println("Não há vagas no curso de código $codigoCurso")
    } catch (e: Exception) {
        println("Erro na execução. Info: ${e.message}")
    }


}