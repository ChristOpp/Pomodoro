package de.copp.pomodoro.presentation.uicomponents

import androidx.compose.foundation.clickable
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ControlIcon(
    icon : ImageVector,
    onClick : () -> Unit,
    modifier : Modifier = Modifier,

) {
    Icon(
        imageVector = icon,

        contentDescription = null,
        modifier = modifier.clickable { onClick() }
    )
}


