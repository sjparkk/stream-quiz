package com.growup.streamquiz.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

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


}
