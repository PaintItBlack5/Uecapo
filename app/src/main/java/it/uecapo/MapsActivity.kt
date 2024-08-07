package it.uecapo

import android.content.Intent
import android.location.Address
import android.location.Geocoder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_maps.*
import java.io.IOException


class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var location: String

    private lateinit var mMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.

        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        button.setOnClickListener {
            val postiLiberiActivity = Intent(this@MapsActivity, PostiLiberiActivity::class.java)
            postiLiberiActivity.putExtra("Locazione", location)
            startActivity(postiLiberiActivity)
        }
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {

        mMap = googleMap

        val bundle = intent.getBundleExtra("welcome_activity_data")

        val citta = bundle.getString("citta")
        val via = bundle.getString("via")


        location = "$citta, $via"
        var addressList: List<Address>? = null

        val geoCoder = Geocoder(this)

        try {
            addressList = geoCoder.getFromLocationName(location, 1)

        } catch (e: IOException) {
            e.printStackTrace()
        }
        val address = addressList!![0]
        val latLng = LatLng(address.latitude, address.longitude)

        // Add a marker in Sydney and move the camera
        //val sydney = LatLng(-34.0, 151.0)
        val zoomLevel = 16.0f
        mMap.addMarker(MarkerOptions().position(latLng).title(location))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, zoomLevel))

    }
}
