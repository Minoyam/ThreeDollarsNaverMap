package com.mino.navermap

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.mino.navermap.databinding.ItemNaverMapBinding
import com.naver.maps.geometry.LatLng
import com.naver.maps.map.NaverMap
import com.naver.maps.map.NaverMapSdk
import com.naver.maps.map.OnMapReadyCallback

class NaverMapCustomView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr), OnMapReadyCallback {

    private lateinit var naverMap: NaverMap

    private val binding: ItemNaverMapBinding = DataBindingUtil.inflate(
        LayoutInflater.from(context),
        R.layout.item_naver_map,
        this,
        true
    )

    var currentPosition: LatLng? = null


    override fun onMapReady(map: NaverMap) {
        naverMap = map
    }

    fun initNaverMapSdk(clientId: String) {
        NaverMapSdk.getInstance(context).client = NaverMapSdk.NaverCloudPlatformClient(clientId)
    }

}