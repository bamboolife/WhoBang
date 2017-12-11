package com.whombang.amaplibrary.clustering.algo;


import com.amap.api.maps.model.LatLng;
import com.whombang.amaplibrary.clustering.Cluster;
import com.whombang.amaplibrary.clustering.ClusterItem;


import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 一个以创造为中心的集群
 */
public class StaticCluster<T extends ClusterItem> implements Cluster<T> {
    private final LatLng mCenter;
    private final List<T> mItems = new ArrayList<T>();

    public StaticCluster(LatLng center) {
        mCenter = center;
    }



    public boolean add(T t) {
        return mItems.add(t);
    }

    @Override
    public LatLng getPosition() {
        return mCenter;
    }

    public boolean remove(T t) {
        return mItems.remove(t);
    }

    @Override
    public Collection<T> getItems() {
        return mItems;
    }

    @Override
    public int getSize() {
        return mItems.size();
    }

    @Override
    public String toString() {
        return "StaticCluster{"
                + "mCenter=" + mCenter
                + ", mItems.size=" + mItems.size()
                + '}';
    }
}