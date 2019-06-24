package com.advlatam.cloudtaxi.domain.interactors.taxirequest

import com.advlatam.cloudtaxi.models.TaxiRequest

interface ISendTaxiRequestInteractor {
    fun sendReqTaxi(taxiRequest: TaxiRequest)
}