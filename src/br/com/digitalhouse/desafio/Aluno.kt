package br.com.digitalhouse.desafio

class Aluno(
        codigo: Int,
        nome: String,
        sobrenome: String) : Pessoa(codigo, nome, sobrenome) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return return codigo.hashCode()
    }
}