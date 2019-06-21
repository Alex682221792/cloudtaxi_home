package com.advlatam.cloudtaxi.domain.interactors.register

import com.google.firebase.auth.FirebaseAuth

class RegisterInteractorImpl : IRegisterInteractor{

    override fun signUpWithFirebase(email: String, password: String, listener: IRegisterInteractor.signUpCallback) {
        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if(it.isSuccessful){
                listener.onSignUpSucess()
            }else{
                listener.onSignUpFailure(it.exception?.message!!)
            }

        }
    }
}