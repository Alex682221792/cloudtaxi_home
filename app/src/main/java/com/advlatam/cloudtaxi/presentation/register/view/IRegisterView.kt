package com.advlatam.cloudtaxi.presentation.register.view

interface IRegisterView{
    fun registerUser()
    fun showProgressBar()
    fun hideProgressBar()
    fun showMessage(message:String)
    fun goToMainMenu()
}