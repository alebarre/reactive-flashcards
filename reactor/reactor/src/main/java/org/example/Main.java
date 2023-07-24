package org.example;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Mono.justOrEmpty(null)
                .defaultIfEmpty(1)
                .doOnSuccess(System.out::println)
                .subscribe();

        System.out.println("-------------------");

        Mono.justOrEmpty(2)
                .map(n -> n * n)
                .doOnSuccess(System.out::println)
                .subscribe();

        System.out.println("-------------------");

        Mono.justOrEmpty(11)
                .filter(a -> a % 2 == 0)
                .defaultIfEmpty(2)
                .doOnSuccess(n -> System.out.println(n))
                .subscribe();

        System.out.println("-------------------");

        //Mostra valor a valor
        Flux.fromIterable(List.of(1, 2, 3, 4, 5, 6, 7, 8))
                .map(n -> n * 10)
                .doOnNext(System.out::println)
                .subscribe();

        System.out.println("-------------------");

        //monta uma lista
        Flux.fromIterable(List.of(1, 2, 3, 4, 5, 6, 7, 8))
                .map(n -> n * 10)
                .collectList()
                .doOnNext(System.out::println)
                .subscribe();

        System.out.println("-------------------");

    }
}

