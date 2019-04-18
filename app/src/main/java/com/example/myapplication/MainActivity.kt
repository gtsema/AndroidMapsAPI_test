package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager

        val googleMapsFragment = SupportMapFragment()
        googleMapsFragment.getMapAsync(this)
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(R.id.container, googleMapsFragment)
        fragmentTransaction.commit()

        googleBtn.setOnClickListener {
            val googleMapsFragment = SupportMapFragment()
            googleMapsFragment.getMapAsync(this)
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.container, googleMapsFragment)
            fragmentTransaction.commit()
        }

        yandexBtn.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val yandexFragment = YandexMapFragment()
            fragmentTransaction.replace(R.id.container, yandexFragment)
            fragmentTransaction.commit()
        }

        osmBtn.setOnClickListener {
            val fragmentTransaction = fragmentManager.beginTransaction()
            val osmFragment = OSMMapFragment()
            fragmentTransaction.replace(R.id.container, osmFragment)
            fragmentTransaction.commit()
        }

    }

    override fun onMapReady(googleMap: GoogleMap) {}
}
