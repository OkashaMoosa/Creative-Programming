package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // TODO: Write code here
        List<Integer> numbers = new ArrayList<>();

        ReactiveSources.intNumbersFlux()
                .doOnNext(x -> numbers.add(x))
                .doOnComplete(() -> System.out.println(numbers + "\n" + numbers.size()))
                .subscribe();

        //Alternative Approach
        List<Integer> numbers2 = ReactiveSources.intNumbersFlux().toStream().toList();
        System.out.println(numbers2);
        System.out.println(numbers2.size());


        System.out.println("Press a key to end");
        System.in.read();
    }

}
