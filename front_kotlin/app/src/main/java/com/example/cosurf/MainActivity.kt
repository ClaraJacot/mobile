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
import androidx.compose.ui.tooling.preview.Preview
import com.example.cosurf.model.surfspots
import com.example.cosurf.ui.theme.CosurfTheme
import com.example.cosurf.model.surfspots
import com.example.cosurf.view.AllSurfSpots
import com.example.cosurf.view.SurfSpotCard
//import com.example.cosurf.view.SpotList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CosurfTheme {
                AllSurfSpots(surfspots)
                //SpotList()

            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CosurfTheme {
        AllSurfSpots(surfspots)
        //SpotList()

    }
}