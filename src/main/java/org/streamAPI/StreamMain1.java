package org.streamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMain1 {
    public static void main(String[] args) {
        
        //create a list and filter all even numbers from list
        List<Integer> list1 = List.of(2,3,50,84,75);

        List<Integer> list2=new ArrayList<>();
        list2.add(12);
        list2.add(13);
        list2.add(54);
        list2.add(10);

        List<Integer> list3 = Arrays.asList(75,46,95,12,63);

        //Filter Even Number
        List<Integer> filterrList = list1.stream().filter(x->x%2==0).collect(Collectors.toList());
        System.out.println("Filtered Even List :"+ filterrList);

        //Filter greater the 50
        List<Integer> GreaterList = list1.stream().filter(x->x>50).collect(Collectors.toList());
        System.out.println("Greater the 50 List :"+GreaterList);

        //array, object, collection
        String names[] = {"John", "Ketty", "Jame"};
        Arrays.stream(names).forEach(System.out::println);
        Stream<String> stream1=Stream.of(names);
        stream1.forEach(x->{System.out.print(x+ ",");});
        System.out.println();

        //Builder Pattern
        Stream<Object>stream2 = Stream.builder().build();

        //Array pattern
        IntStream intStream =  Arrays.stream(new int[]{2,5,7});
        intStream.forEach(System.out::println);
        System.out.println();
        System.out.println();

        //List, Set
        list2.stream().forEach(System.out::println);

        System.out.println();

        //filter(predicate)->return boolean or perform on boolean
        // boolean valued function
        Arrays.stream(names).filter(s->s.startsWith("J")).forEach(System.out::println);

        System.out.println();
        //map(function) ->perform on function
        // each ele operation
        list1.stream().map(x->x*x).forEach(System.out::println);

        System.out.println();

        //Sorted
        list1.stream().sorted().forEach(System.out::println);

        //min
        Integer integer = list1.stream().min((x,y)->x.compareTo(y)).get();
        System.out.println("Min number :: "+integer);

        //max
        Integer integer2 = list1.stream().max((x,y)->x.compareTo(y)).get();
        System.out.println("Max number :: "+integer2);
    }
}
