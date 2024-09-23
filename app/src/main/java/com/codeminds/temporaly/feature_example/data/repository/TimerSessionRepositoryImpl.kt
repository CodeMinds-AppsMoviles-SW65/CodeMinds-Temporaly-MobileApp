package com.codeminds.temporaly.feature_example.data.repository

import com.codeminds.temporaly.feature_example.data.local.dao.TimerSessionDao
import com.codeminds.temporaly.feature_example.domain.repository.TimerSessionRepository
import com.codeminds.temporaly.feature_example.domain.model.TimerSessionModel
import com.codeminds.temporaly.feature_example.domain.model.toTimerSessionEntity
import javax.inject.Inject

class TimerSessionRepositoryImpl @Inject constructor(private val timerSessionDao: TimerSessionDao) :
    TimerSessionRepository {
    override suspend fun saveTimerSession(timerSessionModel: TimerSessionModel): Boolean {
        try {
            val result =
                timerSessionDao.insertTimerSession(timerSessionModel.toTimerSessionEntity())
            return result.toInt() != -1
        } catch (e: Exception) {
            throw e
        }
    }

    override suspend fun getTimerSessionByDate(date: String): TimerSessionModel {
        try {
            var timerValue: Long = 0
            var rounds = 0
            timerSessionDao.getTimerSessionByDate(date).map { session ->
                timerValue += session.value ?: 0
                rounds += 1
            }
            return TimerSessionModel(
                date = date,
                value = timerValue,
                round = rounds
            )
        } catch (e: Exception) {
            throw e
        }
    }
}