package com.insta.instagram.model;

public class Test {

    public static void main(String[] args) {
        Object o = 0.01;
        Long clicks = (long) (new Double(String.valueOf(o)) * 1L);
    }
}
