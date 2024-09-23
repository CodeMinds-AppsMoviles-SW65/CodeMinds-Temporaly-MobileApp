package com.codeminds.temporaly.feature_example.domain.repository

import com.codeminds.temporaly.feature_example.domain.model.TimerSessionModel


interface TimerSessionRepository {
    suspend fun saveTimerSession(timerSessionModel: TimerSessionModel): Boolean

    suspend fun getTimerSessionByDate(date: String): TimerSessionModel
}