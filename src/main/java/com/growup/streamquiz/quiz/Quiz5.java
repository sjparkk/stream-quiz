package com.growup.streamquiz.quiz;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Quiz5 {

    // 1번 : 문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 모든 문자열의 길이를 더한 결과를 출력하여라.
    public static void quiz1() {

        String[] strArr = {"aaa","bb","c","dddd"};

        IntSummaryStatistics totalLength = Arrays.stream(strArr)
                .collect(Collectors.summarizingInt(String::length));

        System.out.println(totalLength.getSum());

    }

    // 2번 :문자열 배열 String[] strArr = {"aaa","bb","c","dddd"}의 문자열 중에서 가장 긴 것의 길이를 출력하시오.
    public static void quiz2() {

        String[] strArr = {"aaa","bb","c","dddd"};

        int maxLength = Arrays.stream(strArr)
                .mapToInt(String::length)
                .max()
                .orElseThrow(NoSuchFieldError::new);
        System.out.println(maxLength);

    }

    // 3번 : 임의의 로또번호(1~45)를 정렬해서 출력하시오. (총 6개의 숫자라고 가정)
    public static void quiz3() {
        List<Integer> lottoNum = getLottoNum();

        List<Integer> collect = lottoNum.stream()
                .sorted()
                .collect(Collectors.toList());

        collect.forEach(System.out::println);
    }

    private static List<Integer> getLottoNum() {
        return new Random().ints(1, 46)
                .distinct()
                .limit(6)
                .boxed()
                .collect(Collectors.toList());
        //        일반적인 방법
        //        Set<Integer> lotto = new HashSet<>();
        //        while ( lotto.size() < 6) {
        //            lotto.add((int) ((Math.random() * 45) + 1));
        //        }
    }

    // 4번 : 두 개의 주사위를 굴려서 나온 눈의 합이 6인 경우를 모두 출력하시오.
    public static void quiz4() {
        Stream<Integer> dies = IntStream.rangeClosed(1, 6).boxed();

        List<Integer[]> collect = dies.flatMap(i -> IntStream.rangeClosed(1, 6).boxed().map(j -> new Integer[]{i, j}))
                .filter(x -> x[0] + x[1] == 6).collect(Collectors.toList());

        collect.forEach( x -> System.out.printf("%d + %d = %d, ", x[0], x[1], x[0]+x[1]));

    }


}
