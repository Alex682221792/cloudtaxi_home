package com.advlatam.cloudtaxi.presentation.map

import android.content.Context
import android.content.pm.PackageManager
import android.location.Geocoder
import android.location.Location
import android.os.Bundle
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.advlatam.cloudtaxi.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.map_view.*

class MapFragment: Fragment(),
    GoogleMap.OnMarkerClickListener {


    private var googleMap: GoogleMap? = null

    private lateinit var lastLocation: Location

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    private var destino : MarkerOptions? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        println("********on  create map")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, bundle: Bundle?): View? {
        val view = inflater!!.inflate(R.layout.map_view,container,false)

        var mMapView =  view.findViewById(R.id.fragment_map) as MapView
        mMapView.onCreate(bundle)

        mMapView.onResume()

        mMapView.getMapAsync{
            this.onMapReady(it)
        }

        return view
    }

    fun onMapReady(googleMap: GoogleMap?) {
        println("init onMapReady")
        this.googleMap = googleMap as GoogleMap

        this.googleMap?.uiSettings?.isZoomControlsEnabled = true
        this.googleMap?.setOnMarkerClickListener(this)

        this.googleMap?.setOnMapClickListener {
            this.drawGoal(it)
        }
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())
        this.setUpMap()
    }

    companion object {
        private const val LOCATION_PERMISSION_REQUEST_CODE = 1
    }

    private fun setUpMap() {
        if (ActivityCompat.checkSelfPermission(requireContext(),
                android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(requireActivity(),
                arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), LOCATION_PERMISSION_REQUEST_CODE)
            return
        }
        this.googleMap?.isMyLocationEnabled = true

        fusedLocationClient.lastLocation.addOnSuccessListener(requireActivity()) { location ->
            // Got last known location. In some rare situations this can be null.
            if (location != null) {
                lastLocation = location
                val currentLatLng = LatLng(location.latitude, location.longitude)
                placeMarkerOnMap(currentLatLng, getString(R.string.labelMarkerHere))
                this.googleMap?.animateCamera(CameraUpdateFactory.newLatLngZoom(currentLatLng, 15f))
            }
        }
    }

    override fun onMarkerClick(p0: Marker?) = false

    private fun drawGoal(goal: LatLng){

        this.googleMap?.clear()
        this.placeMarkerOnMap(LatLng(lastLocation.latitude, lastLocation.longitude),
            getString(R.string.labelMarkerHere))
        this.placeMarkerOnMap(goal, getString(R.string.labelMarkerGoal))
    }


    private fun placeMarkerOnMap(location: LatLng, label: String) {
        val markerOptions = MarkerOptions().position(location).title(label)
        this.googleMap?.addMarker(markerOptions)
    }



}