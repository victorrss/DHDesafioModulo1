package br.com.digitalhouse.desafio

abstract class Pessoa(
        val codigo: Int,
        val nome: String,
        val sobrenome: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Pessoa) return false

        if (codigo != other.codigo) return false

        return true
    }
}