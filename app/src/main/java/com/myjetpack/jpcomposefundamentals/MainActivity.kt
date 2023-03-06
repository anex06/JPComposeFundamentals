package com.myjetpack.jpcomposefundamentals

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.myjetpack.jpcomposefundamentals.ui.theme.JPComposeFundamentalsTheme
import com.myjetpack.jpcomposefundamentals.ui.theme.Shapes

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JPComposeFundamentalsTheme {
                // A surface container using the 'background' color from the theme
                MyApp()
            }

        }
    }
}

@Composable
fun MyApp(){
    val moneyCounter = remember {
        mutableStateOf(0)
    }
    Surface(modifier = Modifier
        .fillMaxSize(),
        color = Color(0xFF546E7A)){
        Column(verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text(text = "$${moneyCounter.value}",
            style = TextStyle(
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
            ))
            Spacer(modifier = Modifier.height(30.dp))
            CreateCircle(moneyCounter=moneyCounter.value){
                moneyCounter.value = it
            }
        }

        }
    }


//@Preview
@Composable
fun CreateCircle(moneyCounter: Int = 0, updateCounter:(Int)->Unit){
    Card(modifier = Modifier
        .padding(3.dp)
        .size(100.dp)
        .clickable {
            updateCounter(moneyCounter + 10)
        },
        shape = CircleShape,
        elevation = 4.dp) {
        Box(contentAlignment = Alignment.Center) {
            Text(text = "Tap", fontWeight = FontWeight.Bold)
        }

    }
}
val lambda:(Int, Int) ->Int={
    a,b-> a+b
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    JPComposeFundamentalsTheme {
      MyApp()
    }
}