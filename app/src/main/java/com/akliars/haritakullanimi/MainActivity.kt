package com.akliars.haritakullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.akliars.haritakullanimi.databinding.ActivityMainBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() , OnMapReadyCallback {
    private lateinit var binding: ActivityMainBinding
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.buttonKonumaGit.setOnClickListener {
            val konum = LatLng(41.0361566, 28.9854576)
            mMap.addMarker(
                MarkerOptions()
                .position(konum)
                .title("Konum").icon(BitmapDescriptorFactory.fromResource(R.drawable.resim)))
            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(konum,17f))
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val konum = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions()
            .position(konum)
            .title("Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(konum))
    }
}
