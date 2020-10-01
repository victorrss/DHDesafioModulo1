package br.com.digitalhouse.desafio

import java.util.*

class Matricula(
        val codigo: Int,
        val aluno: Aluno,
        val curso: Curso) {
    val dtMatricula = Date()
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Matricula) return false

        if (aluno.codigo != other.aluno.codigo && curso.codigo != other.curso.codigo) return false

        return true
    }

    override fun hashCode(): Int {
        return return aluno.codigo.hashCode() + curso.codigo.hashCode()
    }
}