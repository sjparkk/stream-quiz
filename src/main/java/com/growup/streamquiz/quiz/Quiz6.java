package com.growup.streamquiz.quiz;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Quiz6 {

    private static Student[] studentArr;

    @Getter
    @AllArgsConstructor
    @Setter
    public static class Student {
        private String name;
        private boolean isMale; // 성별
        private int hak; // 학년
        private int ban; // 반
        private int score;

        public String toString() {
            return String.format("[%s, %s, %d학년 %d반, %3d점 ]", name, isMale ? "남" : "여", hak, ban, score);
        }

        // groupingBy()에서 사용 성적을 상,중,하 세 단계로 분류
        enum Level {
            HIGH, MID, LOW
        }
    }

    public static void initData() {
        studentArr =  new Student[]{
                new Student("나자바", true, 1, 1, 300),
                new Student("김지미", false, 1, 1, 250),
                new Student("김자바", true, 1, 1, 200),
                new Student("이지미", false, 1, 2, 150),
                new Student("남자바", true, 1, 2, 100),
                new Student("안지미", false, 1, 2, 50),
                new Student("황지미", false, 1, 3, 100),
                new Student("강지미", false, 1, 3, 150),
                new Student("이자바", true, 1, 3, 200),
                new Student("나자바", true, 2, 1, 300),
                new Student("김지미", false, 2, 1, 250),
                new Student("김자바", true, 2, 1, 200),
                new Student("이지미", false, 2, 2, 150),
                new Student("남자바", true, 2, 2, 100),
                new Student("안지미", false, 2, 2, 50),
                new Student("황지미", false, 2, 3, 100),
                new Student("강지미", false, 2, 3, 150),
                new Student("이자바", true, 2, 3, 200) };
    }

    //문제 1 : stuArr에서 불합격(150점 미만)한 학생들을 구별하여라.
    public static void quiz1() {
        initData();

        List<String> stuList = Stream.of(studentArr)
                .filter(s -> s.getScore() < 150)
                .map(s -> s.getHak() + "학년 " + s.getBan() + "반 " + s.getName())
                .collect(Collectors.toList());
        stuList.forEach(System.out::println);
    }
}
