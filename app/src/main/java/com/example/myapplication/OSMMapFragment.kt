package com.example.myapplication

import android.app.Application
import android.os.Bundle
import android.os.Environment
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import org.osmdroid.mapsforge.MapsForgeTileProvider
import org.osmdroid.mapsforge.MapsForgeTileSource
import org.osmdroid.tileprovider.util.SimpleRegisterReceiver
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import java.io.File

class OSMMapFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        MapsForgeTileSource.createInstance(context!!.applicationContext as Application)

        val map = MapView(context)

        val path = Environment.getExternalStorageDirectory().path + "/mapsforge/"
        val folder = File(path)
        val listOfFiles = folder.listFiles()

        val source = MapsForgeTileSource.createFromFiles(listOfFiles, null, "rendertheme-v4")
        val mfProvider = MapsForgeTileProvider(SimpleRegisterReceiver(context), source, null)
        map.tileProvider = mfProvider

        map.setMultiTouchControls(true)

        val startPoint = GeoPoint(59.967032, 30.301350)
        val mapController = map.controller
        mapController.setZoom(15.0)
        mapController.setCenter(startPoint)

        return map
    }
}