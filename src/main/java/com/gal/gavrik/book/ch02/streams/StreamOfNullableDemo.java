package com.gal.gavrik.book.ch02.streams;

import java.util.stream.Stream;

public class StreamOfNullableDemo {
    public static void main(String[] args) {
        Stream<String > values =
                Stream.of("file.separator", "java.class.path", "java.home",
                                "java.vendor", "java.vendor.url", "java.version",
                                "user.dir", "user.home", "user.name")
                        .flatMap(key -> Stream.ofNullable(System.getProperty(key)));
        values.forEach(System.out::println);
    }
}
