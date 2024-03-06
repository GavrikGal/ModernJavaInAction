package com.gal.gavrik.book.ch02.streams;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.gal.gavrik.book.ch02.streams.SectionPrime.partitionPrimes;

public class PrimeNumberCollectorDemo {
    public static void main(String[] args) {
        long fastest = Long.MAX_VALUE;
        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            partitionPrimes(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println(
                "Самое быстрое выполнение partitionPrimes(1_000_000) было произведено за "
                + fastest + " мс"
        );

        for (int i = 0; i < 10; i++) {
            long start = System.nanoTime();
            partitionPrimesWithCustomCollector(1_000_000);
            long duration = (System.nanoTime() - start) / 1_000_000;
            if (duration < fastest) fastest = duration;
        }
        System.out.println(
                "Самое быстрое выполнение partitionPrimesWithCustomCollector(1_000_000)" +
                        " было произведено за "
                        + fastest + " мс"
        );
    }

    public static Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
        return IntStream.rangeClosed(2, n).boxed()
                .collect(new PrimeNumbersCollector());
    }
}
