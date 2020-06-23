package com.rafel.LRU;

public class Main {

    public static void main(String[] args) {
        LRU lru=new LRUCacheNoMap(5);

        lru.put("Durant",1);
        lru.put("James", 2);
        lru.put("Kobe", 3);

        System.out.println(lru);

        lru.get("James");
        lru.put("Wade", 4);
        lru.put("Irving", 5);
        System.out.println(lru);

        lru.put("Jordan", 6);
        System.out.println(lru);
    }
}
