package com.whombang.amaplibrary.clustering;


import com.amap.api.maps.model.LatLng;

import java.util.Collection;

/**
 *这是一组彼此相邻的ClusterItems的集合
 */
public interface Cluster<T extends ClusterItem> {
    public LatLng getPosition();

    Collection<T> getItems();

    int getSize();
}