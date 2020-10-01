package br.com.digitalhouse.desafio.util

import java.text.SimpleDateFormat
import java.util.*

fun Date.toFormatBrazil(): String {
    return SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(this)
}