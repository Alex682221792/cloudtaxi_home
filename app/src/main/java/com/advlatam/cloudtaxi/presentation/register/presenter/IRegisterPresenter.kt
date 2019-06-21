package com.advlatam.cloudtaxi.presentation.register.presenter

import com.advlatam.cloudtaxi.presentation.register.view.IRegisterView

interface IRegisterPresenter{
    fun signUpUser(email: String,password: String)
    fun attachView(view : IRegisterView)
    fun dettachView()
    fun isAttachedView() : Boolean
    fun checkEmailAndPassword(email: String,password: String) : Boolean

}