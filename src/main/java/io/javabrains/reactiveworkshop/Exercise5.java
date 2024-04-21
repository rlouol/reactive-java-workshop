package io.javabrains.reactiveworkshop;

import java.io.IOException;

import org.reactivestreams.Subscription;

import reactor.core.Disposable;
import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux() and ReactiveSources.userFlux()

        // Subscribe to a flux using the error and completion hooks
        Disposable sub = ReactiveSources.intNumbersFlux().subscribe(
            number -> System.out.println(number),
            err -> System.out.println(err.getMessage()),
            () -> System.out.println("Complete!")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.userFlux().subscribe(new MySubscriber<>());
        // ReactiveSources.userMono().subscribe(new MySubscriber<>());
        
        System.out.println("Press a key to end");
        System.in.read();
    }

}

// Mono일 경우 2개 이상의 req가 올 때 2번째 이후는 무시됨
// Base Function: BaseSubscriber 참조
class MySubscriber<T> extends BaseSubscriber<T> {
    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe happened");  
        request(1);
    }

    public void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
        request(3);
    }
}