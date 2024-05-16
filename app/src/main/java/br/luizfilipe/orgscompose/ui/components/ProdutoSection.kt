package br.luizfilipe.orgscompose.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.luizfilipe.orgscompose.R
import br.luizfilipe.orgscompose.model.Product
import java.math.BigDecimal

@Composable
fun ProductSection(
    title: String,
    products: List<Product>
) {
    Column {
        Text(
            text = title,
            Modifier.padding(
                start = 16.dp,
                end = 16.dp
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            Modifier
                .padding(
                    top = 8.dp
                )
                .fillMaxWidth()
                .horizontalScroll(
                    rememberScrollState()
                ),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Spacer(modifier = Modifier)
            for (p in products){
                ProdutoItem(product = p)
            }
            Spacer(modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductSectionPreview() {
    ProductSection("Promotions", sampleProducts)
}


val sampleProducts = listOf(
    Product(
        name = "Hamburguer",
        price = BigDecimal("12.99"),
        imagem = R.drawable.imagelanche,
        description = "Haburguer saboroso"
    ),

    Product(
        name = "Pizza",
        price = BigDecimal("19.99"),
        imagem = R.drawable.pizza
    ),
    Product(
        name = "Batata frita",
        price = BigDecimal("7.99"),
        imagem = R.drawable.batata,
        description = "Batata frita com cheddar"
    )
)