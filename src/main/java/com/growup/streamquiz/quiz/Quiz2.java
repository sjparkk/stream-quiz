package com.growup.streamquiz.quiz;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Quiz2 {

    private static final List<String> WORDS1 = Arrays.asList("TONY", "a", "hULK", "B", "america", "X", "nebula", "Korea");

    //문제 1 : List에 저장된 단어들의 접두사가 각각 몇개씩 있는지 Map<String, Integer>으로 변환하여라. ex) ("T", 1), ("a", 2) ...
    public static Map quiz1() {
        // 문제에서 요구하는  Map<String, Integer> 형태의 맵 생성
        Map<String, Integer> wordCountMap = new HashMap<>();
        // 스트림을 이용 + map(w -> w.substring(0,1)) : 앞글자만 자름 T, a, h, ... + forEach를 통한 반복 + 생성해둔 wordCountMap에 앞에서 잘랐던 T, a .. 순으로 merge를 통해 기본값 1 넣어주고 이후 한번더 나오는 a같은 경우는 처음 1 나중 1되서 2가 됨
        WORDS1.stream().map(w -> w.substring(0,1)).forEach(prefix -> wordCountMap.merge( prefix, 1, (oldVal, newVal) -> newVal += oldVal));
        // 위에 merge 작업으로 wordCountMap 내용이 업데이트되었으므로 출력해줌 + keySet()을 통해 k 값으로 key값을 가져오고 wordCountMap.get(k)를 통해 해당 key값의 value를 가져온다.
        wordCountMap.keySet().forEach(k -> System.out.println(k + " : " + wordCountMap.get(k)));
        return wordCountMap;
    }


}
