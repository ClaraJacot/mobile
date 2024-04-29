package com.example.cosurf.view
import com.example.cosurf.model.Spot
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable


@Composable
fun SpotList() {
    LazyColumn {
        items(Spot.listSpot) {fullName ->
            SpotItem(fullName = fullName)

        }
    }

}