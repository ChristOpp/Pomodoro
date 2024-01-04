package de.copp.pomodoro.presentation.Timer

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import de.copp.pomodoro.presentation.uicomponents.ControlIcon

@Composable
fun TimerScreen(viewModel: TimerViewModel) {

    val state by viewModel.state.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Text(text = state.timeRemain.toString(), fontSize = 48.sp)

        if (state.isRunning) {
            ControlIcon(
                icon = Icons.Default.Close,
                onClick = { viewModel.stopTimerClicked() },
                modifier = Modifier
                    .size(48.dp)
                    .padding(top = 32.dp)
            )
        }
        else {
            ControlIcon(
                icon = Icons.Default.PlayArrow,
                onClick = { viewModel.startTimerClicked() },
                modifier = Modifier
                    .size(48.dp)
                    .padding(top = 32.dp)
            )
        }


        Icon(
            imageVector = Icons.Default.Refresh,
            contentDescription = null,
            modifier = Modifier
                .size(48.dp)
                .padding(top = 32.dp)
                .clickable { viewModel.resetTimerClicked() }
        )
    }

}
