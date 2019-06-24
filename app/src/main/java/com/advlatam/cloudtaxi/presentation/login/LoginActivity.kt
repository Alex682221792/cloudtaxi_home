package com.advlatam.cloudtaxi.presentation.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.advlatam.cloudtaxi.R
import com.advlatam.cloudtaxi.base.ActivityBase
import com.advlatam.cloudtaxi.domain.interactors.login.LoginInteractorImpl
import com.advlatam.cloudtaxi.presentation.login.presenter.ILoginPresenter
import com.advlatam.cloudtaxi.presentation.login.presenter.LoginPresenterImpl
import com.advlatam.cloudtaxi.presentation.login.view.ILoginView
import com.advlatam.cloudtaxi.presentation.menu.MenuActivity
import com.advlatam.cloudtaxi.presentation.register.RegisterActivity
import kotlinx.android.synthetic.main.login_view.*

class LoginActivity : ActivityBase(), ILoginView{

    lateinit var presenter: ILoginPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_view)
        this.initLoginPresenter()
        this.initFunctionButtons()
    }

    private fun initLoginPresenter(){
        this.presenter = LoginPresenterImpl(LoginInteractorImpl())
        this.presenter.attachView(this)
    }

    private fun initFunctionButtons(){
        buttonLogin.setOnClickListener{
            this.signIn()
        }
        buttonGoToRegister.setOnClickListener {
            this.goToRegister()
        }
    }

    override fun signIn() {
        val email = txtEmail.text.toString().trim()
        val pass = txtPassword.text.toString().trim()
        this.presenter.signInUser(email, pass)
        if(this.presenter.checkEmailAndPassword(email, pass)) {
            this.showProgressBar()
        }else{
            toast(this, getString(R.string.msgEmptyFields))
        }
    }

    override fun showProgressBar() {
        this.setProgressBarLoginVisibility(View.VISIBLE)
        this.setButtonLoginVisibility(View.INVISIBLE)
    }

    override fun hideProgressBar() {
        this.setProgressBarLoginVisibility(View.INVISIBLE)
        this.setButtonLoginVisibility(View.VISIBLE)
    }

    override fun showMessage(message: String) {
        toast(this, message)
    }

    override fun goToMainMenu() {
        val intent = Intent(this, MenuActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
        startActivity(intent)

    }

    override fun goToRegister() {
        startActivity(Intent(this, RegisterActivity::class.java))
    }

    fun setProgressBarLoginVisibility(visibility:Int){
        progressBarLogin.visibility = visibility
    }

    fun setButtonLoginVisibility(visibility: Int){
        buttonLogin.visibility = visibility
    }
}
