package io.javabrains.reactiveworkshop;

import reactor.core.publisher.Flux;

import java.io.IOException;

public class Exercise7 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux().filter(x -> x > 5).subscribe(x -> System.out.println(x));

        // Print 10 times each value from intNumbersFlux that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                .flatMap(x -> Flux.just(x).repeat(9))
                .subscribe(x -> System.out.println(x));

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                .take(3)
                .flatMap(x -> Flux.just(x).repeat(9))
                .subscribe(x -> System.out.println(x));

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 20)
                .defaultIfEmpty(-1)
                .subscribe(x -> System.out.println(x));
        // Switch ints from intNumbersFlux to the right user from userFlux
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .flatMap(x -> ReactiveSources.userFlux().filter(user -> user.getId() == x))
                .subscribe();

        // Print only distinct numbers from intNumbersFluxWithRepeat
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinct()
                .subscribe(x -> System.out.println(x));

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        // TODO: Write code here
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(x -> System.out.println(x));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
