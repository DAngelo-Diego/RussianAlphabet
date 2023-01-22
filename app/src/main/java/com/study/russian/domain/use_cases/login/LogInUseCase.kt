package com.study.russian.domain.use_cases.login

import com.study.russian.domain.model.User
import com.study.russian.domain.repository.LoginRepository
import com.study.russian.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class LogInUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(email: String, password: String): Flow<DataState<Boolean>> =
        loginRepository.login(email, password)
    }
