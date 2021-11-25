package com.growup.streamquiz.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Quiz4 {

    private static List<Transaction> transactions;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Trader {
        private String name;
        private String city;
    }

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Transaction {
        private Trader trader;
        private int year;
        private int value;
    }

    //초기값
    public static void init() {
        Trader kyu = new Trader("Kyu", "Seoul");
        Trader ming = new Trader("Ming", "Gyeonggi");
        Trader hyuk = new Trader("Hyuk", "Incheon");
        Trader hwan = new Trader("Hwan", "Seoul");

        transactions = Arrays.asList(
                new Transaction(kyu, 2019, 30000),
                new Transaction(kyu, 2020, 12000),
                new Transaction(ming, 2020, 40000),
                new Transaction(ming, 2020, 7100),
                new Transaction(hyuk, 2019, 5900),
                new Transaction(hwan, 2020, 4900));
    }

    //quiz1 : 2020년에 일어난 모든 거래 내역을 찾아 거래값을 기준으로 오름차순 정렬하라. -> 정답 : 4900, 7100, 12000, 40000
    //filter / sorted
    public static void quiz1() {
        init();

        List<Transaction> transactionList = transactions.stream()
                .filter(y -> y.getYear() == 2020)
                .sorted(Comparator.comparing(Transaction::getValue))
                .collect(Collectors.toList());

        transactionList.stream().map(Transaction::getValue).forEach(System.out::println);
    }


}
