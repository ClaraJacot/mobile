package com.example.cosurf.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cosurf.model.data.Photo
import com.example.cosurf.model.data.Record
import com.example.cosurf.model.data.Welcome

@Composable
fun AllSurfSpots(navController: NavController, welcome: Welcome) {
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

        items(welcome.records) { surfSpot ->
            SurfSpotCard(
                surfSpot, surfPhoto = surfSpot.fields.photos[0],
            ) { navController.navigate("spotItem/${surfSpot.id}") }
        }

    }
    }
}

/*@Preview(showBackground = true, showSystemUi = true)
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
*/

