package com.rafel.LRU;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LRUCache implements LRU {
    private int Max_Cache_Size;

    private LinkedHashMap<String, Integer> map;

    public LRUCache(int cacheSize) {
        this.Max_Cache_Size = cacheSize;
        int capacity = (int) Math.ceil(Max_Cache_Size / 0.75f) + 1;
        // accessOrder为true是按照最近最少使用插入元素，false则是按照插入顺序
        map = new LinkedHashMap<String, Integer>(capacity, 0.75f, true) {
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return size() > Max_Cache_Size;
            }

        };
    }

    @Override
    public void put(String s, int i) {
        map.put(s, i);
    }


    @Override
    public int get(String s) {
        return map.get(s);
    }

    @Override
    public void remove(String s) {
        map.remove(s);
    }

    @Override
    public Set<String> getAll() {
        return map.keySet();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            stringBuilder.append(String.format("%s: %s  ", entry.getKey(), entry.getValue()));
        }
        return stringBuilder.toString();
    }

}
