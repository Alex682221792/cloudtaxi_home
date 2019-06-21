package com.advlatam.cloudtaxi.presentation.login.presenter

import com.advlatam.cloudtaxi.presentation.login.view.ILoginView

interface ILoginPresenter{
    fun signInUser(email : String, password : String)
    fun attachView(view : ILoginView)
    fun dettachView()
    fun isAttachedView() : Boolean
    fun checkEmailAndPassword(email: String,password: String) : Boolean
}