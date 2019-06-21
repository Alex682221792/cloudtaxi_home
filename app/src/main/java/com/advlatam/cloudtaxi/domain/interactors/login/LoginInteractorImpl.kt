package com.advlatam.cloudtaxi.domain.interactors.login

import com.google.firebase.auth.FirebaseAuth

class LoginInteractorImpl : ILoginInteractor{
    override fun signInWithFirebaseAuth(email: String, password: String, listener: ILoginInteractor.signInCallback) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener{
            if(it.isSuccessful){
                listener.onSignInSucess()
            }else{
                listener.onSignInFailure(it.exception?.message!!)
            }
        }
    }
}