package com.gal.gavrik.book.ch02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionStreams {
    public static void main(String[] args) {
        Trader raoul = new Trader("Raoul", "Cambridge");
        Trader mario = new Trader("Mario","Milan");
        Trader alan = new Trader("Alan","Cambridge");
        Trader brian = new Trader("Brian","Cambridge");
        List<Transaction> transactions = Arrays.asList(
                new Transaction(brian, 2011, 300),
                new Transaction(raoul, 2012, 1000),
                new Transaction(raoul, 2011, 400),
                new Transaction(mario, 2012, 710),
                new Transaction(mario, 2012, 700),
                new Transaction(alan, 2012, 950) );

        transactions.stream()
                .filter(transaction -> transaction.getYear() == 2011)
                .sorted(Comparator.comparing(Transaction::getValue))
                .toList().forEach(System.out::println);
        System.out.println();

        transactions.stream()
                .map(transaction -> transaction.getTrader().getCity())
                .distinct()
                .toList().forEach(System.out::println);
        System.out.println();

        transactions.stream()
                .map(Transaction::getTrader)
                .filter(trader -> trader.getCity().equals("Cambridge"))
                .distinct()
                .sorted(Comparator.comparing(Trader::getName))
                .toList().forEach(System.out::println);
        System.out.println();

        String names = transactions.stream()
                .map(Transaction::getTrader)
                .distinct()
                .map(Trader::getName)
                .sorted()
                .collect(Collectors.joining(" "));
        System.out.println(names);
        System.out.println();

        boolean hasTraderFromMilan = transactions.stream()
                .anyMatch(transaction -> transaction.getTrader().getCity().equals("Milan"));
        System.out.println(hasTraderFromMilan);
        System.out.println();

        transactions.stream()
                .filter(transaction -> transaction.getTrader().getCity().equals("Cambridge"))
                .map(Transaction::getValue)
                .forEach(System.out::println);
        System.out.println();

        Integer maxTransactionValue = transactions.stream()
                .map(Transaction::getValue)
                .max(Integer::compareTo).orElse(null);
        System.out.println(maxTransactionValue);
        System.out.println();

        Transaction minValueTransaction = transactions.stream()
                .min(Comparator.comparing(Transaction::getValue)).orElse(null);
        System.out.println(minValueTransaction);

    }

}
