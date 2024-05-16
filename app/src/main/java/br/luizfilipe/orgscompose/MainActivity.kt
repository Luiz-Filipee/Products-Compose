package br.luizfilipe.orgscompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import br.luizfilipe.orgscompose.ui.screens.HomeScreen
import br.luizfilipe.orgscompose.ui.theme.OrgsComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    OrgsComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface {
            HomeScreen()
        }
    }
}

//@Preview(
//    name = "Desafio",
//    showBackground = true
//)
//@Composable
//fun Desafio() {
//    Row(Modifier.fillMaxWidth()) {
//        Box(modifier = Modifier
//            .height(100.dp)
//            .width(80.dp)
//            .background(Color.Blue)
//        )
//        Column {
//            Text(text = "Test 1", Modifier
//                .background(Color.LightGray)
//                .padding(8.dp)
//                .fillMaxWidth())
//            Text(text = "Test 2", Modifier
//                .padding(8.dp)
//                .fillMaxWidth())
//        }
//    }
//}

//@Preview(
//    showBackground = true,
//)
//@Composable
//fun DesafioRow() {
//    Surface(
//        Modifier.padding(8.dp),
//        shape = RoundedCornerShape(15.dp),
//        shadowElevation = 8.dp
//    ) {
//        Row(
//            Modifier
//                .widthIn(500.dp, 550.dp)
//                .height(200.dp)
//        ) {
//            val imageSize = 100.dp
//            Box(
//                modifier = Modifier
//                    .width(110.dp)
//                    .background(
//                        Brush.verticalGradient(
//                            listOf(
//                                Purple500, Teal200
//                            )
//                        )
//                    )
//                    .fillMaxHeight()
//            ) {
//                Image(
//                    painter = painterResource(id = R.drawable.ic_launcher_background),
//                    contentDescription = null,
//                    Modifier
//                        .size(imageSize)
//                        .offset(x = imageSize / 2)
//                        .clip(CircleShape)
//                        .align(CenterEnd)
//                        .border(
//                            2.dp, Brush.linearGradient(
//                                listOf(
//                                    Purple500, Teal200
//                                )
//                            ), CircleShape
//                        )
//                )
//            }
//            Spacer(modifier = Modifier.width(imageSize / 2))
//            Text(text = LoremIpsum(50).values.first(),
//                Modifier.padding(30.dp),
//                fontSize = 14.sp,
//                overflow = TextOverflow.Ellipsis)
//        }
//    }
//}