package org.example;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Delhi");
        list.add("Hyd");
        list.add("Kansas");

        for (String str : list) {
            if (str.equalsIgnoreCase("Kansas")) {
                list.remove(str);
                list.add("Fremont");
            }
        }
        System.out.println(list);
    }
}
