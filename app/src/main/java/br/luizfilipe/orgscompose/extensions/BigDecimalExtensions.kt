package br.luizfilipe.orgscompose.extensions

import java.math.BigDecimal
import java.text.NumberFormat
import java.util.Locale

fun BigDecimal.toBrazilCurrency(): String {
    return NumberFormat.getCurrencyInstance(Locale("pt", "br")).format(this)
}