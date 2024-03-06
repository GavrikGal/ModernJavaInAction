package com.gal.gavrik.book.ch02.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class SectionPrime {
    public static void main(String[] args) {
        Map<Boolean, List<Integer>> booleanListMap = partitionPrimes(30);
        System.out.println(booleanListMap);
    }

    public static boolean isPrime(int candidate) {
        int candidateRoot = (int) Math.sqrt((double) candidate);
        return IntStream.rangeClosed(2, candidateRoot)
                .noneMatch(i -> candidate % i == 0);
    }

    public static Map<Boolean, List<Integer>> partitionPrimes(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(
                        partitioningBy(SectionPrime::isPrime)
                );
    }
}
