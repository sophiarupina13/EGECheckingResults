package org.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class EgeMain {
    public static void main(String[] args) {
        var applicationContext = new AnnotationConfigApplicationContext(EgeConfiguration.class);
        var answersProcessor = applicationContext.getBean(AnswersProcessor.class);
        var resultProcessor = applicationContext.getBean(ResultProcessor.class);

        List<Character> correctAnswers = answersProcessor.getCorrectAnswersAsList();
        List<Character> studentAnswers = answersProcessor.getStudentAnswersAsList();

        System.out.println(resultProcessor.getExaminationScores(correctAnswers,studentAnswers));
    }
}