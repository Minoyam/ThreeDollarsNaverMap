package com.mino.navermap

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.mino.navermap.databinding.ItemNaverMapBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.*
import com.naver.maps.map.overlay.Marker

class NaverMapCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), OnMapReadyCallback {

    private lateinit var naverMap: NaverMap

    private lateinit var fusedLocationProviderClient: FusedLocationProviderClient

    val binding: ItemNaverMapBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.item_naver_map,
        this,
        true
    )
    private val markers = arrayListOf<Marker>()

    var currentPosition: LatLng? = null

    init {
        binding.fragmentMap.getMapAsync(this)
    }
    override fun onMapReady(map: NaverMap) {
        naverMap = map
    }

    fun initNaverMapSdk(clientId: String) {
        NaverMapSdk.getInstance(context).client = NaverMapSdk.NaverCloudPlatformClient(clientId)
    }

    fun initFusedLocationProviderClient(activity: Activity) {
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity)
    }

    @SuppressLint("MissingPermission")
    fun moveToCurrentLocation(
        showAnim: Boolean = false,
        isLocationAvailable: Boolean,
        isGpsAvailable: Boolean
    ) {
        try {
            if (isLocationAvailable && isGpsAvailable) {
                val locationResult = fusedLocationProviderClient.lastLocation
                locationResult.addOnSuccessListener {
                    if (it != null) {
                        currentPosition = LatLng(it.latitude, it.longitude)
                        currentPosition?.let { position ->
                            if (showAnim) {
                                moveCameraWithAnim(position)
                            } else {
                                moveCamera(position)
                            }
                            onMyLocationLoaded(position)
                        }
                    }
                }
            }
        } catch (e: Exception) {
            Log.e(this::class.java.name, e.message ?: "")
            moveCamera(LatLng(37.56, 126.97)) // 서울
        }
    }

    fun moveCameraWithAnim(position: LatLng) {
        if (naverMap == null) {
            return
        }

        val cameraUpdate = CameraUpdate.scrollTo(position).animate(CameraAnimation.Easing)
        naverMap?.moveCamera(cameraUpdate)
    }

    fun moveCamera(position: LatLng) {
        if (naverMap == null) {
            return
        }

        val cameraUpdate = CameraUpdate.scrollTo(position)
        naverMap?.moveCamera(cameraUpdate)
    }

    open fun onMyLocationLoaded(position: LatLng) {
        // do nothing
    }

}