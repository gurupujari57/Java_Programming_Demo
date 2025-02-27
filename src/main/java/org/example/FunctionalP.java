package org.example;


import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.BiFunction;
import java.util.stream.Collectors;


public class FunctionalP {
    public static void main(String args[]){
        //1.Runnable

     /*   Runnable runnable
                =()
                -> System.out.println(
                        "Running in Runnable thread"
        );
        runnable.run();
        System.out.println(
                "Running in main thread"
        );*/

        //2.For Each

        List<Integer> numbers= Arrays.asList(11,22,33,44,55);
       /* for(int num: numbers){
            System.out.print(num + " ");
        }*/

        //3.For Each
//        numbers.forEach(num-> System.out.println(num + " "));

//        4.Declarative Approach--
     /*   int res=0;
        for(Integer n : numbers){
            if(n %2 ==0){
                res += n * 2;
            }
        }
        System.out.print(res);*/

        int factor=2;
        System.out.println(
                numbers.stream()
                        .filter(num->num % 2 == 0)
                         .mapToInt(e ->e * factor)
                        .sum());

        //Streams Intermidiate Operation
        //map
        List <Integer>number = Arrays.asList(2,3,4,5);
        List square = number.stream()
                .map(x ->x*x)
                .collect(Collectors.toList());
        System.out.println(square+" ");


        //filter
        List<String> name=Arrays.asList("IOS","Android","Testing","Backend");
        List namefilter=name.stream().filter(s->s.startsWith("A")).collect(Collectors.toList());
        System.out.println(namefilter+" ");

        //Sorting
        List<Integer> num=Arrays.asList(4,5,8,1,3,2);
        List sortnum=num.stream().sorted().collect(Collectors.toList());
        System.out.println(sortnum+" ");

        //Stream Terminal operation
        //collect--- ref above

        //foreach
        List<Integer> intnum=Arrays.asList(2,3,4,5);
        intnum.stream().map(x -> x * x).forEach(y -> System.out.print(y+" "));
        System.out.println();

        //reduce
        int even=intnum.stream().filter(x -> x%2==0).reduce(0,(ans,i)->ans+i);
        System.out.println(even+" ");

        //Function---->apply()

        //BiFunction
        BiFunction<Integer,Integer,Integer> sum=(a, b)-> a+b;



    }
}
