package com.advlatam.cloudtaxi.presentation.menu

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import com.advlatam.cloudtaxi.R
import com.advlatam.cloudtaxi.base.ActivityBase
import com.advlatam.cloudtaxi.presentation.map.MapFragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.main_menu_view.*

class MenuActivity: ActivityBase(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        println("*********Menu activiyy")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_menu_view)
        this.initMenu()
        this.loadOption(R.layout.login_view)
    }

    private fun initMenu(){
        navigationView.setNavigationItemSelectedListener(this)
        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this, drawer_layout_main_menu, toolbar, R.string.navigation_drawer_open,
            R.string.navigation_drawer_close)
        toggle.setDrawerIndicatorEnabled(true)
        drawer_layout_main_menu.addDrawerListener(toggle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//        supportActionBar?.setHomeButtonEnabled(true)
    }

    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.nav_item_donde->{
                this.loadOption(R.layout.map_view)
                toast(this, "a donde te diriges?")
            }
            R.id.nav_item_reserva->{
                this.loadOption(R.layout.login_view)
                toast(this, "Realizar reserva")
            }
        }
        drawer_layout_main_menu.closeDrawer(GravityCompat.START)
        return true
    }

    private fun loadOption(layoutId: Int){
/*
        container_inflate.removeAllViews()
        //var view = layoutInflater.inflate(R.layout.map_view, null)
        container_inflate.addView(MapFragment().layoutInflater.inflate(R.layout.map_view, null))
*/



        val mapFrag = MapFragment()

        // Get the support fragment manager instance
        val manager = supportFragmentManager

        // Begin the fragment transition using support fragment manager
        val transaction = manager.beginTransaction()

        // Replace the fragment on container
        transaction.replace(R.id.container_inflate,mapFrag)
        transaction.addToBackStack(null)

        // Finishing the transition
        transaction.commit()
    }

}