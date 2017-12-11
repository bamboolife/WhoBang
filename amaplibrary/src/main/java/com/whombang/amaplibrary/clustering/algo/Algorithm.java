package com.whombang.amaplibrary.clustering.algo;
import com.whombang.amaplibrary.clustering.Cluster;
import com.whombang.amaplibrary.clustering.ClusterItem;

import java.util.Collection;
import java.util.Set;
public interface Algorithm<T extends ClusterItem> {
    void addItem(T item);

    void addItems(Collection<T> items);

    void clearItems();

    void removeItem(T item);

    Set<? extends Cluster<T>> getClusters(double zoom);

    Collection<T> getItems();
}