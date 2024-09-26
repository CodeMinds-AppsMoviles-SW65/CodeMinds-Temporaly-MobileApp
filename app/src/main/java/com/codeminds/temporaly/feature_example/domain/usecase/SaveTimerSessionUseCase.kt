package com.codeminds.temporaly.feature_example.domain.usecase

import com.codeminds.temporaly.core.utils.Resource
import com.codeminds.temporaly.feature_example.domain.model.TimerSessionModel
import com.codeminds.temporaly.feature_example.domain.repository.TimerSessionRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveTimerSessionUseCase @Inject constructor(
    private val repository: TimerSessionRepository
) {
    operator fun invoke(timerSessionModel: TimerSessionModel): Flow<Resource<Boolean>> = flow {
        try {
            emit(Resource.Loading())
            emit(
                Resource.Success(
                    data = repository.saveTimerSession(timerSessionModel)
                )
            )

        } catch (e: Exception) {
            emit(Resource.Error(e.message ?: "Unknown Error"))
        }
    }
}