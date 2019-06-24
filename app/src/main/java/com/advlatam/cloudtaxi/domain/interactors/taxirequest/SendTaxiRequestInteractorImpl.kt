package com.advlatam.cloudtaxi.domain.interactors.taxirequest

import com.advlatam.cloudtaxi.models.TaxiRequest
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class SendTaxiRequestInteractorImpl : ISendTaxiRequestInteractor{
    override fun sendReqTaxi(taxiRequest: TaxiRequest) {
        var mDatabase: DatabaseReference? = null
        mDatabase = FirebaseDatabase.getInstance().getReferenceFromUrl("https://cloudtaxi-8dd82.firebaseio.com/")
        mDatabase.setValue(taxiRequest)
    }
}