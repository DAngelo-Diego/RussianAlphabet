package com.study.russian.util

object Constants {

    const val INFO_NOT_SET = "info_not_set"
    const val USERS_COLLECTIONS = "users"

    private const val USER_NOT_LOGGED = "user_not_logged"

    var USER_LOGGED_IN_ID = USER_NOT_LOGGED

    const val EMAIL_ALREADY_EXISTS : String = "com.google.firebase.auth.FirebaseAuthUserCollisionException: The email address is already in use by another account."

    //fragment_login use it
    const val USER_NOT_EXISTS = "There is no user record corresponding to this identifier. The user may have been deleted."
    const val WRONG_PASSWORD = "The password is invalid or the user does not have a password."

    const val VALUE_REQUIRED = "Value Required"
}