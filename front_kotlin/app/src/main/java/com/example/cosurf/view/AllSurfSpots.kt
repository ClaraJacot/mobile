package com.example.cosurf.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController


import com.example.cosurf.model.data.SurfSpot

@Composable
fun AllSurfSpots(navController: NavController, platList: List<SurfSpot>) {
    Column {
    ScaffoldSurf(
        title = "\uD83C\uDFC4\u200D♀\uFE0F Surf Spots",
        icon = null,
        onIconClicked = null
    )

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {

        items(platList) { surfSpot ->
            SurfSpotCard(
                surfSpot.name,
                surfSpot.picture,
                surfSpot.address,
                surfSpot.id
            ) { navController.navigate("spotItem/${surfSpot.id}") }
        }
    }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun AllSurfSpotsPreview() {
    val surfSpotList = listOf(
        SurfSpot(
            name = "Spot 1",
            address = "Adresse du spot",
            id = "1",
            picture = ""
        ),
        SurfSpot(
            name = "Spot 2",
            address = "Adresse du spot",
            id = "2",
            picture = ""
        ),
        SurfSpot(
            name = "Spot 3",
            address = "Adresse du spot",
            id = "3",
            picture = ""
        )

    )
    val navController = rememberNavController()

    AllSurfSpots(navController = navController, platList = surfSpotList)
}


