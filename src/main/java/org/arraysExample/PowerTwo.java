package org.arraysExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PowerTwo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,3,8,12,16,6);
        System.out.println(getPower(list));
    }

    public static List<Integer> getPower(List<Integer> arr){
        List<Integer> list = new ArrayList<>();
        for (int a :arr){
            if(a>0 && (a&(a-1))==0){
                list.add(1);
            }else {
                list.add(0);
            }
        }
        return list;
    }
}
