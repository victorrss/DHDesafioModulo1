package br.com.digitalhouse.desafio

abstract class Professor(
        codigo: Int,
        nome: String,
        sobrenome: String,
        val tempoCasa: Int) : Pessoa(codigo, nome, sobrenome) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}