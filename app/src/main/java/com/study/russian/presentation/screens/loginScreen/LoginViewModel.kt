package com.study.russian.presentation.screens.loginScreen

import android.provider.ContactsContract.Data
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.study.russian.domain.use_cases.login.GetUserDataUseCase
import com.study.russian.domain.use_cases.login.LogInUseCase
import com.study.russian.domain.use_cases.logout.LogOutUseCase
import com.study.russian.domain.use_cases.signup.SaveUserUseCase
import com.study.russian.util.DataState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val logInUseCase: LogInUseCase,
    private val logOutUseCase: LogOutUseCase,
    private val getUserDataUseCase: GetUserDataUseCase
): ViewModel() {

    private val _loginState: MutableLiveData<DataState<Boolean>> = MutableLiveData()
    val loginState: LiveData<DataState<Boolean>> = _loginState

    private val _logOut: MutableLiveData<DataState<Boolean>> = MutableLiveData()
    val logOut: LiveData<DataState<Boolean>> = _logOut

    private val _userDataState: MutableLiveData<DataState<Boolean>> = MutableLiveData()
    val userDataState: LiveData<DataState<Boolean>>
    get() = _userDataState

    fun login(email: String, password: String){
        viewModelScope.launch {
            logInUseCase(email, password)
                .onEach {dataState ->
                    _loginState.value = dataState
                }.launchIn(viewModelScope)
        }
    }

    fun logOut(){
        viewModelScope.launch {
            logOutUseCase()
                .onEach {dataState ->
                    _logOut.value = dataState
                }.launchIn(viewModelScope)
        }
    }

    fun getUserData(){
        viewModelScope.launch {
            getUserDataUseCase()
                .onEach {dataState ->
                    _userDataState.value = dataState
                }.launchIn(viewModelScope)
        }
    }

}