package com.advlatam.cloudtaxi.presentation.map.presenter

import com.advlatam.cloudtaxi.presentation.map.view.IMapFragment

interface IRequestTaxiPresenter {
    fun attachView(view : IMapFragment)
    fun dettachView()
    fun isAttachedView() : Boolean
    fun sendTaxiRequest(Lat: Double, Lng: Double, UserID: Int)
}