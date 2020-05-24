package com.atguigu.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class test {

    public static void main(String[] args) {
        // create array list
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13);


        list = list.subList(10, list.size() - 10 >= 10 ? 10 + 10 : list.size());
        System.out.println(list);
    }
}
