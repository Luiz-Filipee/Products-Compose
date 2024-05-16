package br.luizfilipe.orgscompose.model

import androidx.annotation.DrawableRes
import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    @DrawableRes val imagem: Int,
    val description: String = ""
)