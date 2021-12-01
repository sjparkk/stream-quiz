package com.growup.streamquiz;

import com.growup.streamquiz.quiz.Quiz2;
import com.growup.streamquiz.quiz.Quiz4;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamQuizApplication.class, args);

		Quiz4.quiz5();
	}

}
