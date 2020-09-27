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

        if (codigo != other.codigo) return false

        return true
    }
}