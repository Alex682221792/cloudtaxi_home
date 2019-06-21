package com.advlatam.cloudtaxi.presentation.login.presenter

import com.advlatam.cloudtaxi.domain.interactors.login.ILoginInteractor
import com.advlatam.cloudtaxi.presentation.login.view.ILoginView

class LoginPresenterImpl(loginInteractor : ILoginInteractor) : ILoginPresenter{
    var view: ILoginView? = null
    var loginInteractor : ILoginInteractor? = null

    init {
        this.loginInteractor = loginInteractor
    }

    override fun signInUser(email: String, password: String) {
        this.loginInteractor?.signInWithFirebaseAuth(email, password, object : ILoginInteractor.signInCallback{
            override fun onSignInSucess() {
                if(isAttachedView()) {
                    view?.hideProgressBar()
                    view?.goToMainMenu()
                }
            }

            override fun onSignInFailure(error: String) {
                if(isAttachedView()) {
                    view?.hideProgressBar()
                    view?.showMessage(error)
                }
            }
        })
    }

    override fun attachView(view: ILoginView) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun isAttachedView(): Boolean {
        return this.view != null
    }

    override fun checkEmailAndPassword(email: String, password: String)  : Boolean {
        return email.isNotBlank() && password.isNotBlank()
    }
}