package com.rafel.LRU;

import java.util.Set;

public interface LRU {

    public void put(String s, int i);

    public int get(String s);

    public void remove(String s);

    public Set<String> getAll();

}
