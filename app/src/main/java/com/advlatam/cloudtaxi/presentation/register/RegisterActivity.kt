package com.advlatam.cloudtaxi.presentation.register

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.advlatam.cloudtaxi.R
import com.advlatam.cloudtaxi.base.ActivityBase
import com.advlatam.cloudtaxi.domain.interactors.register.RegisterInteractorImpl
import com.advlatam.cloudtaxi.presentation.menu.MenuActivity
import com.advlatam.cloudtaxi.presentation.register.presenter.IRegisterPresenter
import com.advlatam.cloudtaxi.presentation.register.presenter.RegisterPresenterImpl
import com.advlatam.cloudtaxi.presentation.register.view.IRegisterView
import kotlinx.android.synthetic.main.register_view.*

class RegisterActivity : ActivityBase(), IRegisterView{

    lateinit var presenter: IRegisterPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register_view)
    }

    private fun initPresenterRegister(){
        this.presenter = RegisterPresenterImpl(RegisterInteractorImpl())
    }

    override fun registerUser() {

    }

    override fun showProgressBar() {
        this.setProgressBarRegisterVisibility(View.VISIBLE)
        this.setButtonRegisterVisibility(View.INVISIBLE)
    }

    override fun goToMainMenu(){
        val intent = Intent(this,MenuActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)
    }

    override fun hideProgressBar() {
        this.setProgressBarRegisterVisibility(View.INVISIBLE)
        this.setButtonRegisterVisibility(View.VISIBLE)
    }

    override fun showMessage(message: String) {
        toast(this, message)
    }

    fun setProgressBarRegisterVisibility(visibility:Int){
        progressBarRegister.visibility = visibility
    }

    fun setButtonRegisterVisibility(visibility: Int){
        buttonRegister.visibility = visibility
    }
}