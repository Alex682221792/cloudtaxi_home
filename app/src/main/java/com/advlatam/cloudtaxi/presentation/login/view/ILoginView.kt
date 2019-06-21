package com.advlatam.cloudtaxi.presentation.login.view

interface ILoginView{
    fun signIn()
    fun showProgressBar()
    fun hideProgressBar()
    fun showMessage(message:String)
    fun goToMainMenu()
    fun goToRegister()
}