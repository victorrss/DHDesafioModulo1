package br.com.digitalhouse.desafio

class Professor(
        codigo: Int,
        nome: String,
        sobrenome: String,
        val tempoCasa: Int) : Pessoa(codigo, nome, sobrenome)