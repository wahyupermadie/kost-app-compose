package id.godohembon.kuykost

import android.os.Bundle
import android.widget.ImageView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import id.godohembon.kuykost.ui.theme.KuyKostTheme
import id.godohembon.kuykost.utils.FontHelper.openSansFamily

class MainActivity : ComponentActivity() {
    @ExperimentalMaterialApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeView()
        }
    }
}

@ExperimentalMaterialApi
@Composable
fun HomeView() {
    KuyKostTheme {
        var text by remember { mutableStateOf("") }

        // A surface container using the 'background' color from the theme
        Surface(color = MaterialTheme.colors.background) {
            Scaffold(
                topBar = {
                    TopAppBar(
                        title = {
                            Text(text = "Properti Saya")
                        },
                    )
                }
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    OutlinedTextField(
                        leadingIcon = {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_search),
                                contentDescription = "search_icon"
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        value = text,
                        onValueChange = {
                            text = it
                        }
                    )

                    Card(
                        onClick = { /*TODO*/ },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, top = 8.dp),
                        elevation = 4.dp
                    ) {
                        ConstraintLayout {

                            val (contentDesc, contentImg) = createRefs()

                            Column(
                                modifier = Modifier.constrainAs(contentDesc) {
                                    top.linkTo(parent.top, margin = 16.dp)
                                    start.linkTo(parent.start, margin = 16.dp)
                                    end.linkTo(contentImg.start, margin = 18.dp)
                                    bottom.linkTo(parent.bottom, margin = 56.dp)
                                    width = Dimension.preferredWrapContent
                                }
                            ) {
                                Text(
                                    text = "Kos Tukad Pancoran Mengwi Badung",
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    style = TextStyle(
                                        fontFamily = openSansFamily,
                                        fontWeight = FontWeight.Bold
                                    ),
                                    fontSize = 16.sp
                                )

                                Text(
                                    text = "Jalan Tukad Pancoran, Sading, Mengwi, Bali",
                                    maxLines = 2,
                                    overflow = TextOverflow.Ellipsis,
                                    style = TextStyle(
                                        fontFamily = openSansFamily,
                                        fontWeight = FontWeight.Light
                                    ),
                                    fontSize = 12.sp
                                )
                            }

                            Image(
                                modifier = Modifier
                                    .size(96.dp)
                                    .clip(RoundedCornerShape(8.dp))
                                    .constrainAs(contentImg) {
                                        end.linkTo(parent.end, margin = 16.dp)
                                        top.linkTo(parent.top, margin = 16.dp)
                                    },
                                painter = painterResource(id = R.drawable.ic_house),
                                contentDescription = "house"
                            )
                        }
                    }
                }
            }
        }
    }
}

@ExperimentalMaterialApi
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    HomeView()
}