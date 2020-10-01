package br.com.digitalhouse.desafio

class Curso(val codigo: Int,
            val nome: String,
            val qtdMaxAlunos: Int) {
    val alunos = mutableSetOf<Aluno>()
    var profTitular: ProfessorTitular? = null
    var profAdjunto: ProfessorAdjunto? = null

    fun adicionarUmAluno(aluno: Aluno): Boolean {
        return when {
            !alunos.contains(aluno) && alunos.size < qtdMaxAlunos -> {
                alunos.add(aluno)
                true
            }
            else -> false
        }
    }

    fun excluirAluno(aluno: Aluno) {
        alunos.remove(aluno)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Curso) return false

        if (codigo != other.codigo) return false

        return true
    }

    override fun hashCode(): Int {
        return return codigo.hashCode()
    }
}