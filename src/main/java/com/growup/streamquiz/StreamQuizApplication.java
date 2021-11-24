package com.growup.streamquiz;

import com.growup.streamquiz.quiz2.Quiz2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StreamQuizApplication {

	public static void main(String[] args) {
		SpringApplication.run(StreamQuizApplication.class, args);

		Quiz2.quiz1();
	}

}
