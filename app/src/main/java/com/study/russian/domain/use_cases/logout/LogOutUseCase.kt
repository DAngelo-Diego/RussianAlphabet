package com.study.russian.domain.use_cases.logout

import com.study.russian.domain.repository.LoginRepository
import com.study.russian.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(): Flow<DataState<Boolean>> =
        loginRepository.logOut()
    }

