package com.whombang.amaplibrary.clustering;


import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;

/**
 * ClusterItem表示地图上的一个标记
 */
public interface ClusterItem {

    /**
     * The position of this marker. This must always return the same value.
     */
    LatLng getPosition();

    BitmapDescriptor getBitmapDescriptor();

    String getTitle();

    String getSnippet();
}