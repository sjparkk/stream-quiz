package com.growup.streamquiz.quiz2;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Quiz3 {

    private static List<Integer> numbers1 = Arrays.asList(1, 2, 3);
    private static List<Integer> numbers2 = Arrays.asList(3, 4);

    //다음과 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 배열 리스트를 반환하여라.
    //ex) numbers1 = [1,2,3], numbers2 = [3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
    public static List<Integer[]> quiz1() {
        //List<Integer[]> : Integer 배열을 가지고 있는 리스트 + number1을 기준으로 number2를 합해 쌍을 만드므로 num1을 stream만들어 num2를 합해서 배열을 만드는 형태 + 이때 flatMap을 사용해야 단일원소스트림으로 받을수 있어 반환타입 에러가 안난다.
        //num2로 스트림을 만들어 num1의 값과 num2의 값으로 Interger[]을 만들고 collect를 이용하여 List로 반환한다.
        List<Integer[]> pairNumList = numbers1.stream().flatMap( n -> numbers2.stream().map( m -> new Integer[]{n, m})).collect(Collectors.toList());
        //만들어진 pairNumList을 스트림을 통하여 출력형태를 만들어주고 joining을 통하여 , 을 구분자로 만들어진 String값을 반환한다.
        String result = pairNumList.stream().map( a -> "("+a[0]+","+a[1]+")").collect(Collectors.joining(","));
        System.out.println(result);

        return pairNumList;
    }

    //위와 같은 숫자 리스트가 있을 때 모든 숫자 쌍의 곱이 가장 큰 값을 반환하여라.
    //ex) numbers1 = [1,2,3], numbers2 = [3,4] -> 12
    public static int quiz2() {
        List<Integer> pairNumList = numbers1.stream().flatMap( n -> numbers2.stream().map( m -> n * m)).collect(Collectors.toList());
        Optional<Integer> max = pairNumList.stream().max(Comparator.comparing(x -> x));
        System.out.println(max.get());
        return max.get();
    }

}
