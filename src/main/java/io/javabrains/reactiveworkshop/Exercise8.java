package io.javabrains.reactiveworkshop;

import java.io.IOException;

public class Exercise8 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFluxWithException()

        // Print values from intNumbersFluxWithException and print a message when error happens
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .subscribe(
                        e -> System.out.println(e),
                        err -> System.out.println(err.getMessage())
                );


        // Print values from intNumbersFluxWithException and continue on errors
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithException()
                .onErrorContinue((err, obj) -> System.out.println(err.getMessage()))
                .subscribe(
                        e -> System.out.println(e)
                );
        // Print values from intNumbersFluxWithException and when errors
        // happen, replace with a fallback sequence of -1 and -2
        // TODO: Write code here
        

        System.out.println("Press a key to end");
        System.in.read();
    }

}
