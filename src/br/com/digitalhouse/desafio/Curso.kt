package br.com.digitalhouse.desafio

abstract class Curso(val codigo: Int,
                     val nome: String,
                     val profTitular: ProfessorTitular,
                     val profAdjunto: ProfessorAdjunto,
                     val qtdMaxAlunos: Int) {
    val alunos = mutableListOf<Aluno>()

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Curso) return false

        if (codigo != other.codigo) return false

        return true
    }
}