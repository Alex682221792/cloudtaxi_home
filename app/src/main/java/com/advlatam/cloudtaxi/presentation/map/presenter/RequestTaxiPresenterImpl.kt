package com.advlatam.cloudtaxi.presentation.map.presenter

import com.advlatam.cloudtaxi.domain.interactors.taxirequest.ISendTaxiRequestInteractor
import com.advlatam.cloudtaxi.models.TaxiRequest
import com.advlatam.cloudtaxi.presentation.map.view.IMapFragment

class RequestTaxiPresenterImpl(sendTaxiRequestInteractor: ISendTaxiRequestInteractor) : IRequestTaxiPresenter {
    var view : IMapFragment? = null
    var sendTaxiRequestInteractor: ISendTaxiRequestInteractor? = null

    init {
        this.sendTaxiRequestInteractor = sendTaxiRequestInteractor
    }

    override fun attachView(view: IMapFragment) {
        this.view = view
    }

    override fun dettachView() {
        this.view = null
    }

    override fun isAttachedView(): Boolean {
        return this.view != null
    }

    override fun sendTaxiRequest(Lat: Double, Lng: Double, UserID: Int) {
        var dataTaxiRequest = TaxiRequest(Lat, Lng, UserID)
        this.sendTaxiRequestInteractor?.sendReqTaxi(dataTaxiRequest)
    }
}