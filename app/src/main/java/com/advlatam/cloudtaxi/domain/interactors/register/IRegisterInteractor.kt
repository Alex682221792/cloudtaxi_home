package com.advlatam.cloudtaxi.domain.interactors.register

interface IRegisterInteractor {
    interface signUpCallback{
        fun onSignUpSucess()
        fun onSignUpFailure(error: String)
    }

    fun signUpWithFirebase(email: String, password: String, listener: signUpCallback)
}