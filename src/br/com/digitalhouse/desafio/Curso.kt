package br.com.digitalhouse.desafio

abstract class Curso(val codigo: Int, val nome: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Curso) return false

        if (codigo != other.codigo) return false

        return true
    }
}