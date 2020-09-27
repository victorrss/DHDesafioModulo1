package br.com.digitalhouse.desafio

class ProfessorAdjunto(
        codigo: Int,
        nome: String,
        sobrenome: String,
        tempoCasa: Int,
        horasMonitoria: Int) : Professor(codigo, nome, sobrenome, tempoCasa) {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }
}