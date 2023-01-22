package com.study.russian.domain.model

import com.study.russian.util.Constants.INFO_NOT_SET

data class User (
        val email: String = INFO_NOT_SET,
        val id: String = INFO_NOT_SET
)