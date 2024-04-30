package com.example.cosurf.view
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlin.random.Random

@Composable
fun SpotItem(name: String, address: String, picture: String) {
    Column(

        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp)
            .clickable { },
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       Box(modifier = Modifier
            .size(350.dp)
            .padding(8.dp)
           .shadow(6.dp)
            .border(2.dp, Color.Black )
            .background(Color(Random.nextInt()))
        ) {
            Text(text = picture,
                style = MaterialTheme.typography.bodyMedium,
                modifier = Modifier.align(Alignment.Center)
            )


            }
        Text(modifier = Modifier.padding(top = 20.dp),
            text = name,
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold)
        Text(
            text = address,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
        Text(modifier = Modifier.padding(top = 20.dp),
            text = "Description :",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
        Text(modifier = Modifier.padding(top = 20.dp),
            text = "Nombre de requins :",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
        Text(modifier = Modifier.padding(top = 20.dp),
            text = "Température de l'eau :",
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun SpotItemPreview() {
    SpotItem(
        name = "Reef Break ",
        address = "Pipeline, Oahu, Hawaii",
        picture = "urlImage")
}
