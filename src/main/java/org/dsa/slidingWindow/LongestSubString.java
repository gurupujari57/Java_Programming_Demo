package org.dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubString {
    public static void main(String[] args) {
        String str = "aabacebebebe";
        int unique_char_length = 3;
        int res = getLongestStr(str,unique_char_length);
        System.out.println(res);
    }

    public static int getLongestStr(String str, int k){
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int i=0, j=0;
        while (j<str.length()){
            map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+1);

            if(map.size()<k){
                j++;
            } else if (map.size()==k) {
                max = Math.max(max,j-i+1);
                j++;
            } else if (map.size()>k) {
                while (map.size()>k){
                    map.put(str.charAt(i),map.get(str.charAt(i))-1);
                    if(map.get(str.charAt(i))==0){
                        map.remove(str.charAt(i));
                    }
                    i++;
                }
                j++;
            }
        }
        return max;
    }
}
