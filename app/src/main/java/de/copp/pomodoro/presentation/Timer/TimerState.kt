package de.copp.pomodoro.presentation.Timer

data class TimerState(
    val isRunning: Boolean = false,
    val timeRemain: Long = 0,
    val pomodoro: Long = 10,
    val longBreak: Long = 0,
    val shortBreak: Long = 0,
)