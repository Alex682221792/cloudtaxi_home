package com.advlatam.cloudtaxi.models
import java.io.Serializable

class TaxiRequest : Serializable{
    public var Lat: Double = 0.0
    public var Lng: Double = 0.0
    public var UserID: Int = 0

    constructor(Lat: Double, Lng: Double, UserID: Int){
        this.Lat = Lat
        this.Lng = Lng
        this.UserID = UserID
    }
}