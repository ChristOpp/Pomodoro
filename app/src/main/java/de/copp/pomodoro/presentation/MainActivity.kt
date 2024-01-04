package de.copp.pomodoro.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import de.copp.pomodoro.presentation.Timer.TimerScreen
import de.copp.pomodoro.presentation.Timer.TimerViewModel
import de.copp.pomodoro.ui.theme.PomodoroTheme

class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<TimerViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PomodoroTheme {
                TimerScreen(viewModel)
            }
        }
    }
}
