package com.rafel.LRU;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class LRUCacheNoMap implements LRU {

    // Node类
    class Node {
        public String key;
        public int val;
        public Node next, prev;

        public Node(String k, int v) {
            this.key = k;
            this.val = v;

        }
    }

    // 双向链表类
    class DoubleList {
        private Node head, tail;
        private int size;

        public DoubleList() {
            head = new Node("head", 0);
            tail = new Node("tail", 0);

            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        // 头插法插入元素，链表头部元素是最近访问
        public void addFirst(Node x) {
            x.next = head.next;
            x.prev = head;
            head.next.prev = x;
            head.next = x;

            size++;
        }

        public void remove(Node x) {
            x.prev.next = x.next;
            x.next.prev = x.prev;

            size--;
        }

        public Node removeLast() {
            if (tail == head)
                return null;

            Node last = tail.prev;
            remove(last);
            return last;
        }

        public int size() {
            return size;
        }
    }

    private DoubleList cache;
    private int cap;
    private HashMap<String, Node> map;

    public LRUCacheNoMap(int capacity) {
        this.cap = capacity;
        this.cache = new DoubleList();
        this.map = new HashMap<>();
    }

    @Override
    public void put(String s, int i) {
        // 构造双向链表节点
        Node x = new Node(s, i);
        if (map.containsKey(s)) {
            // 先删除，再添加
            cache.remove(map.get(s));
            cache.addFirst(x);
            // x的前后结点指针更换了，更新map
            map.put(s, x);
        } else {
            if (cap == cache.size) {
                // 删除最后一个节点，同时删除map映射数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            cache.addFirst(x);
            map.put(s, x);
        }
    }

    @Override
    public int get(String s) {
        if (!map.containsKey(s)) return -1;
        int val = map.get(s).val;
        // 利用 put 方法把该数据提前
        put(s, val);
        return val;
    }

    @Override
    public void remove(String s) {
        cache.remove(map.get(s));
        map.remove(s);
    }

    @Override
    public Set<String> getAll() {
        return map.keySet();
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Node head = cache.head;
        for (Node n = head.next; n != head.prev; n = n.next) {
            stringBuilder.append(String.format("%s: %s  ", n.key, n.val));
        }
        return stringBuilder.toString();
    }
}
