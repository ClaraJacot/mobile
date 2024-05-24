package com.example.cosurf.view


import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material.ButtonDefaults.IconSize
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector


@Composable
fun ScaffoldSurf(
    title: String,
    icon: (ImageVector)? = null,
    onIconClicked: (() -> Unit)? = null,
    onAddClicked: (() -> Unit)? = null
) {
    TopAppBar(
        title = {
            Text(text = title)
        },
        navigationIcon = {
            if (onIconClicked != null) {
                IconButton(onClick = { onIconClicked() }) {
                    if (icon != null) {
                        Icon(icon, contentDescription = "Retour")
                    }
                }
            } else {

                Spacer(modifier = Modifier.width(IconSize))
            }
        },
        actions = {
            if (onAddClicked != null) {
                IconButton(onClick = { onAddClicked() }) {
                    Icon(Icons.Default.Add, contentDescription = "Ajouter")
                }
            }
        },
        backgroundColor = MaterialTheme.colorScheme.primary,
        contentColor = MaterialTheme.colorScheme.onPrimary
    )
}
