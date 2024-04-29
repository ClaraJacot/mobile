package com.example.cosurf

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.example.cosurf.ui.theme.CosurfTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CosurfTheme {
                // A surface container using the 'background' color from the theme


                MyScreen()


                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")

                }

            }
        }
    }
}


@Composable
fun MyScreen() {

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        color = Color.Red,
        modifier = modifier

    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CosurfTheme {
        Greeting("Android")
        MyScreen()
    }
}