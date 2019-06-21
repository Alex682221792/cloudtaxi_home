package com.advlatam.cloudtaxi.presentation.register.presenter

import com.advlatam.cloudtaxi.domain.interactors.register.IRegisterInteractor
import com.advlatam.cloudtaxi.presentation.login.view.ILoginView
import com.advlatam.cloudtaxi.presentation.register.view.IRegisterView

class RegisterPresenterImpl(registerInteractor: IRegisterInteractor) : IRegisterPresenter{

    var view: IRegisterView? = null

    var registerInteractor : IRegisterInteractor? = null

    init {
        this.registerInteractor = registerInteractor
    }

    override fun signUpUser(email: String,password: String) {
        this.registerInteractor?.signUpWithFirebase(email, password, object: IRegisterInteractor.signUpCallback{
            override fun onSignUpSucess() {
                if(isAttachedView()) {
                    view?.hideProgressBar()
                    view?.goToMainMenu()
                }
            }

            override fun onSignUpFailure(error: String) {
                if(isAttachedView()) {
                    view?.hideProgressBar()
                    view?.showMessage(error)
                }
            }
        })
    }

    override fun attachView(view: IRegisterView) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun isAttachedView(): Boolean {
        return this.view != null
    }

    override fun checkEmailAndPassword(email: String, password: String): Boolean {
        return email.isNullOrBlank() || password.isNullOrBlank()
    }
}