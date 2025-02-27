package org.dsa.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubStrUnique {
    public static void main(String[] args) {
        String str = "PWWKEW";
        int res = getUniqueCharLength(str);
        System.out.println(res);
    }
    public static int getUniqueCharLength(String str){
        Map<Character,Integer> map = new HashMap<>();
        int max = 0;
        int i=0, j=0;
        while (j<str.length()){
            map.put(str.charAt(j),map.getOrDefault(str.charAt(j),0)+1);

            if(map.size()>j-i+1){
                j++;
            } else if (map.size()==j-i+1) {
                max = Math.max(max,j-i+1);
                j++;
            } else if (map.size()<j-i+1) {
                while (map.size()<j-i+1){
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
