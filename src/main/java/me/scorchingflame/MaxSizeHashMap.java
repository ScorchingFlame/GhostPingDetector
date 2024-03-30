package me.scorchingflame;

import java.util.LinkedHashMap;
import java.util.Map;

public class MaxSizeHashMap<K, V> extends LinkedHashMap<K, V> {
    private int maxSize;

    public MaxSizeHashMap(int maxSize) {
        this.maxSize = maxSize;
    }
    public void setMaxSize(int maxSize) { this.maxSize = maxSize; }
    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return maxSize > 0 && size() > maxSize;
    }
}
