package br.luizfilipe.orgscompose.ui.components

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.luizfilipe.orgscompose.R
import br.luizfilipe.orgscompose.extensions.toBrazilCurrency
import br.luizfilipe.orgscompose.model.Product
import br.luizfilipe.orgscompose.ui.theme.Purple500
import br.luizfilipe.orgscompose.ui.theme.Teal200
import java.math.BigDecimal

@Composable
fun ProdutoItem(product: Product) {
    Surface(
        shape = RoundedCornerShape(15.dp),
        shadowElevation = 4.dp,
    ) {
        Column(
            Modifier
                .width(200.dp)
                .heightIn(250.dp, 260.dp)
                .verticalScroll(rememberScrollState())
        ) {
            val imageSize = 100.dp
            Box(
                modifier = Modifier
                    .height(imageSize)
                    .background(
                        Brush.horizontalGradient(
                            listOf(
                                Purple500, Teal200
                            )
                        )
                    )
                    .fillMaxWidth()
            ) {
                Image(
                    painter = painterResource(id = product.imagem),
                    contentDescription = null,
                    Modifier
                        .size(imageSize)
                        .offset(y = imageSize / 2)
                        .clip(CircleShape)
                        .align(Alignment.BottomCenter),
                    contentScale = ContentScale.Crop
                )
            }
            Spacer(modifier = Modifier.height(imageSize / 2))
            Column(Modifier.padding(16.dp)) {
                Text(
                    text = product.name,
                    fontSize = 18.sp,
                    fontWeight = FontWeight(700),
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = product.price.toBrazilCurrency(),
                    Modifier.padding(top = 8.dp),
                    fontSize = 14.sp,
                    fontWeight = FontWeight(400),
                )
            }
            if (product.description.isNotBlank()) {
                Text(
                    text = product.description,
                    Modifier
                        .background(MaterialTheme.colorScheme.primary)
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                            bottom = 16.dp,
                            top = 8.dp
                        )
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onPrimary
                )
            }
        }
    }
}

@Preview
@Composable
private fun ProductItemPreview() {
    ProdutoItem(
        Product(
            name = LoremIpsum(50).values.first(),
            price = BigDecimal("14.99"),
            imagem = R.drawable.imagelanche
        )
    )
}