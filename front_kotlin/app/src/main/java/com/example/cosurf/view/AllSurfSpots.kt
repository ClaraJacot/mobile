package com.example.cosurf.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp



import com.example.cosurf.model.data.SurfSpot

@Composable
fun AllSurfSpots(platList: List<SurfSpot>) {
    //Scaffold(
        //topBar = {
            //TopAppBar(
                //backgroundColor = MaterialTheme.colors.primary,
                //title = { Text("Cosurf") }
            //)
       // }
    //) {
        LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        contentPadding = PaddingValues(16.dp)
    ) {item {
        Row(
            modifier = Modifier.fillMaxWidth()
                .wrapContentHeight()
                .padding(vertical = 25.dp),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                "\uD83C\uDFC4\u200D♀\uFE0F  Surf Spots",
                style = MaterialTheme.typography.titleLarge
            )
        }
    }
        items(platList) {surfSpot ->
            SurfSpotCard(surfSpot.name, surfSpot.address, surfSpot.picture)
        }
    }
    }


