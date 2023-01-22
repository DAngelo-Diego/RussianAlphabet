package com.study.russian.domain.use_cases.signup

import com.study.russian.domain.model.User
import com.study.russian.domain.repository.LoginRepository
import com.study.russian.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class SaveUserUseCase@Inject constructor(
    private val loginRepository: LoginRepository
) {
    suspend operator fun invoke(user: User): Flow<DataState<Boolean>> =
        loginRepository.saveUser(user)
    }
