package de.copp.pomodoro.presentation.Timer

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class TimerViewModel : ViewModel() {

    private val _state = MutableStateFlow(TimerState())
    val state = _state.asStateFlow()

    init {
        initTimer()
    }

    private fun initTimer() {
        _state.value = state.value.copy(timeRemain = state.value.pomodoro, isRunning = false)
    }

    private fun runTimer() {
        _state.value = state.value.copy(isRunning = true)
        viewModelScope.launch {
            while (state.value.isRunning) {
                delay(1000)
                val time = state.value.timeRemain - 1
                if(time < 0) stopTimerClicked()
                if(state.value.isRunning) _state.value = state.value.copy(timeRemain = time)
            }
        }
    }
    fun stopTimerClicked() {
        _state.value = state.value.copy(isRunning = false)
    }

    fun startTimerClicked() {
        runTimer()
    }


    fun resetTimerClicked() {
        initTimer()
    }

}