package com.advlatam.cloudtaxi.domain.interactors.login

interface ILoginInteractor{
    interface signInCallback{
        fun onSignInSucess()
        fun onSignInFailure(error: String)
    }

    fun signInWithFirebaseAuth(email : String, password : String, listener : signInCallback)
}