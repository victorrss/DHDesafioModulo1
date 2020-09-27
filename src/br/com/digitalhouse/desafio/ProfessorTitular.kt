package br.com.digitalhouse.desafio

class ProfessorTitular(
        codigo: Int,
        nome: String,
        sobrenome: String,
        tempoCasa: Int,
        especialidade: String) : Professor(codigo, nome, sobrenome, tempoCasa) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}