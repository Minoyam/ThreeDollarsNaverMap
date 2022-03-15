package com.mino.threedollarsnavermap

import android.Manifest
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.location.LocationManager
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.content.edit
import androidx.databinding.DataBindingUtil
import com.mino.threedollarsnavermap.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.naverMapCustomView.initNaverMapSdk("6j2u1fccwq")
        binding.naverMapCustomView.initFusedLocationProviderClient(this)

        binding.naverMapCustomView.binding.currentLocationButton.setOnClickListener {
            requestPermissionIfNeeds()
            binding.naverMapCustomView.moveToCurrentLocation(
                false,
                isLocationAvailable(),
                isGpsAvailable()
            )
        }
    }

    fun isLocationAvailable(): Boolean =
        ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

    fun isGpsAvailable(): Boolean {
        val locationManager = getSystemService(LOCATION_SERVICE) as LocationManager
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)
    }

    fun requestPermissionIfNeeds(permission: String = Manifest.permission.ACCESS_FINE_LOCATION) {
        when {
            isLocationAvailable() -> return
            ActivityCompat.shouldShowRequestPermissionRationale(this, permission) -> {
                ActivityCompat.requestPermissions(this, arrayOf(permission), 0)
            }
            else -> {
                if (true) {
                    ActivityCompat.requestPermissions(this, arrayOf(permission), 0)
                } else {
                    openPermissionSettingPage()
                }
            }
        }
    }
    private fun Activity.openPermissionSettingPage() {
        val intent = Intent()
        intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
        intent.data = Uri.fromParts("package", packageName, null)
        startActivity(intent)
    }
}