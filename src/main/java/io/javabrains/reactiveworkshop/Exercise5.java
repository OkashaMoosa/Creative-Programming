package io.javabrains.reactiveworkshop;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .subscribe(x -> System.out.println(x),
                        err -> System.out.println(err.getMessage()),
                        () -> System.out.println("Completed!"));

        // Subscribe to a flux using an implementation of BaseSubscriber
        // TODO: Write code here
        MySubscriber<Integer> mySubscriber = new MySubscriber();
        ReactiveSources.intNumbersFlux()
                .subscribe(mySubscriber);

        System.out.println("Press a key to end");
        System.in.read();
    }

}

class MySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("My Subscriber Created");
        request(1);
    }
}