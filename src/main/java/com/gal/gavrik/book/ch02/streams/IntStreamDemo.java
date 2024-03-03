package com.gal.gavrik.book.ch02.streams;

import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class IntStreamDemo {
    public static void main(String[] args) {
        String range = IntStream.range(1, 10)
                .boxed()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));
        System.out.println(range);

        System.out.println();

        String rangeClosed = IntStream.rangeClosed(1, 10)
                .boxed()
                .map(Objects::toString)
                .collect(Collectors.joining(" "));
        System.out.println(rangeClosed);
    }
}
