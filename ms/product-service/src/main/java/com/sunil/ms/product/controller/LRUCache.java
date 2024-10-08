package com.sunil.ms.product.controller;


import java.util.HashMap;
import java.util.Map;

class LRUCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(2);
        cache.put(1,1);
        cache.put(2,2);
        System.out.println(cache.get(1));

        cache.put(3, 3);
        cache.get(2);
    }

    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);

    int capacity;
    Map<Integer, Node> map = new HashMap();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    public int get (int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insert(node);
            return node.value;
        } else {
            return -1;
        }
    }

        public void put(int key, int value ) {

            if (map.containsKey(key)) {
                Node node = map.get(key);
                remove(map.get(key));
            }
            if (map.size() == capacity) {
                remove(tail.prev);
            }
            insert(new Node(key, value));
        }

        private void remove(Node node) {
            map.remove(node.key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void insert(Node node) {
            node.next = head.next;
            node.next.prev = node;
            head.next = node;
            node.prev = head;
        }
    }

    class Node {
        int key;
        int value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }