package com.gal.gavrik.book.ch02.streams;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class ToListCollector<T> implements Collector<T, List<T>, List<T>> {
    public Supplier<List<T>> supplier() {
        return ArrayList::new;
    }

    public BiConsumer<List<T>, T> accumulator() {
        return List::add;
    }

    public Function<List<T>, List<T>> finisher() {
        return Function.identity();
    }

    public BinaryOperator<List<T>> combiner() {
        return (list1, list2) -> {
            list1.addAll(list2);
            return list1;
        };
    }

    public Set<Characteristics> characteristics() {
        return Collections.unmodifiableSet(EnumSet.of(
                Characteristics.IDENTITY_FINISH,
                Characteristics.CONCURRENT));
    }
}
