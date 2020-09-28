package br.com.digitalhouse.desafio

abstract class Curso(val codigo: Int,
                     val nome: String,
                     val profTitular: ProfessorTitular,
                     val profAdjunto: ProfessorAdjunto,
                     val qtdMaxAlunos: Int) {
    val alunos = mutableListOf<Aluno>()

    fun adicionarUmAluno(aluno: Aluno): Boolean {
        if (alunos.contains(aluno)) {
            alunos.add(aluno)
            return true
        }

        return false
    }

    fun excluirAluno(aluno: Aluno){
        alunos.remove(aluno)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Curso) return false

        if (codigo != other.codigo) return false

        return true
    }
}