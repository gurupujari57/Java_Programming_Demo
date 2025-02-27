package org.arraysExample;

import java.util.Arrays;

public class ArraysZero {
    public static void main(String[] args) {
        int [][] arr={{1,1,1},{1,0,1},{1,1,1}};
        Arrays.stream(arr).forEach(ints -> Arrays.stream(ints).forEach(x-> System.out.print(x+ ",")));
        for(int i=0;i< arr.length;i++){
            for(int j=0;j<arr[i].length;j++){
                if(arr[i][j]==0){
                    arr[i][j]=0;
                }
            }
        }
        System.out.println();
        Arrays.stream(arr).forEach(ints -> Arrays.stream(ints).forEach(x-> System.out.print(x+ ",")));

    }
}
