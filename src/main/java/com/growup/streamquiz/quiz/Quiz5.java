package com.growup.streamquiz.quiz;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class Quiz5 {

    // 1번 : 문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 모든 문자열의 길이를 더한 결과를 출력하여라.
    public static void quiz1() {

        String[] strArr = {"aaa","bb","c","dddd"};

        IntSummaryStatistics totalLength = Arrays.stream(strArr)
                .collect(Collectors.summarizingInt(String::length));

        System.out.println(totalLength.getSum());

    }

}
