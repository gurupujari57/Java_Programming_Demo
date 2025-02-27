package org.arraysExample;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class SubArraySum {
    public static void main(String[] args) {
        int arr[]={2, 3, -8, 7, -1, 2, 3};

       /* ArrayList<Integer> arrayList=new ArrayList<>();

        for(int i=0;i< arr.length;i++){
            if(arr[i]>=0){
                arrayList.add(arr[i]);
            }
        }
        if(arrayList.size()==arr.length){
            List<Integer> sortedList = arrayList.stream().sorted().collect(Collectors.toList());
            System.out.println("SortedList : "+sortedList);
            int sum=0;
            for(int j=sortedList.size()-1;j>0;j--){
              sum+=sortedList.get(j);
            }
            System.out.println("max sum : "+sum);

        }else {
            int sum=0;
            for(int i=0;i<arrayList.size();i++){

                sum+=arrayList.get(i);
            }
            System.out.println("max sum : "+sum);

        }
*/
 /*       int res=arr[0];
        for(int i=0;i<arr.length;i++){
            int currVal=0;
            for(int j=i;j<arr.length;j++){
                currVal=currVal+arr[j];
                    res=Math.max(res,currVal);
            }
        }
        System.out.println("Result :: "+res);*/


        //kadanes Exp

        int maxEnding=arr[0];
        int result=arr[0];

        for (int i=1;i<arr.length;i++){
            maxEnding=Math.max(maxEnding+arr[i],arr[i]);

            result=Math.max(result,maxEnding);
        }
        System.out.println("max sum ::"+result);


    }
}
