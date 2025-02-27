package org.example;

public class ReverseInteger {
    public static void main(String[] args) {
       int res = reverse(123);
        System.out.println(res);
    }
    public static int reverse(int x) {
        int sum=0;
        while(x>0){
            int mod = x%10;
            sum = sum*10+mod;
            x=x/10;
        }
        return sum;
    }
}
