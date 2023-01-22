package com.study.russian.domain.use_cases.signup

import com.study.russian.domain.model.User
import com.study.russian.domain.repository.LoginRepository
import com.study.russian.util.DataState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val loginRepository: LoginRepository
) {

    suspend operator fun invoke(user: User, password:String): Flow<DataState<User>> =
        loginRepository.signUp(user,password)
    }

