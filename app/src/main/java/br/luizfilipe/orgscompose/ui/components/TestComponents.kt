package br.luizfilipe.orgscompose.ui.components

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.luizfilipe.orgscompose.R
import br.luizfilipe.orgscompose.ui.theme.OrgsComposeTheme

class TestComponents {
    data class User(
        val name: String,
        val image: Int,
        val statusOnline: String,
        val minutosAtras: String
    )

    @Composable
    fun myFirstComposable(user: User) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = user.image),
                contentDescription = "testeimage",
                modifier = Modifier
                    .padding(all = 8.dp)
                    .clip(CircleShape)
            )
            Column {
                Row {
                    Text(text = user.name, Modifier.padding(top = 8.dp))
                    Text(text = user.minutosAtras,
                        Modifier
                            .padding(top = 8.dp)
                            .padding(start = 70.dp), color = Color.Gray)
                }
                Text(text = user.statusOnline, Modifier.padding(top = 8.dp), color = Color.Gray)
            }
        }

    }

    @Preview(
        name = "LightMode",
        showBackground = true,
        heightDp = 80,
        widthDp = 400,
    )
    @Preview(
        name = "DarkMode",
        heightDp = 80,
        widthDp = 400,
        showBackground = true,
        uiMode = Configuration.UI_MODE_NIGHT_YES
    )
    @Composable
    fun MyFirstComposablePreview() {
        val user = User("Luiz Filipe Minohala kato",
            R.drawable.ic_launcher_background, "online ha 3 minutos",
            "12:30")
        OrgsComposeTheme {
            Surface {
                myFirstComposable(user) }
        }
    }

    @Composable
    fun CardProduto() {
        MyTextField()
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun MyTextField() {
        var text by remember { mutableStateOf("") }

        TextField(
            value = text,
            onValueChange = { newText ->
                text = newText
            },
            modifier = Modifier,
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            keyboardActions = KeyboardActions(
                onDone = {
                    // Ação quando o usuário pressiona "Done" no teclado
                }
            )
        )
    }

    @Preview(name = "ProdutoCard")
    @Composable
    fun cardProdutoPreview() {
        OrgsComposeTheme {
            Surface {
                CardProduto()
            }
        }
    }
}