package com.example.cosurf.view
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.cosurf.model.data.Photo
import com.example.cosurf.model.data.Record
import kotlin.random.Random

@Composable
fun SpotItem(surfSpot : Record, surfPhoto : Photo, onBackClicked: () -> Unit) {
    Column {
        ScaffoldSurf(
            title = surfSpot.fields.surfBreak.toString(),
            icon = Icons.AutoMirrored.Filled.ArrowBack,
            onIconClicked = onBackClicked
        )




    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 20.dp),

        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )

    {
       Box(modifier = Modifier
           .size(350.dp)
           .padding(6.dp)
           .shadow(6.dp)
           .border(2.dp, Color.Black)
           .background(Color(Random.nextInt()))
        ) {
           AsyncImage(
               model = surfPhoto.url,
               contentDescription = null,
               contentScale = ContentScale.Crop
               )

            }
        Text(modifier = Modifier.padding(top = 20.dp),
            text = surfSpot.fields.surfBreak.joinToString(),
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold)
        Text(
            text = surfSpot.fields.address,
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

}

/*@Preview (showBackground = true, showSystemUi = true)
@Composable
fun SpotItemPreview (){
    val surfSpot = SurfSpot(
        name = "Nom du spot",
        address = "Adresse du spot",
        id = "3",
        picture = ""
    )

    SpotItem(surfSpot = surfSpot, onBackClicked = {})
}*/

