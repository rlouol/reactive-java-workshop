package io.javabrains.reactiveworkshop;

import java.io.IOException;
import java.util.stream.Collectors;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // toList chain method is unsupported in JDK 11
        System.out.println(ReactiveSources.intNumbersFlux().toStream().collect(Collectors.toList()));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
