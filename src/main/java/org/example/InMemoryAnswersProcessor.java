package org.example;

import org.springframework.stereotype.Component;

import java.io.File;
import java.util.List;

@Component
public class InMemoryAnswersProcessor implements AnswersProcessor {

    FileUtils fileUtils = new FileUtils();

    File correctAnswers = new File("./src/main/resources/correct-answers.txt");
    File studentAnswers = new File("./src/main/resources/student-answers.txt");

    @Override
    public List<Character> getCorrectAnswersAsList() {
        return fileUtils.getAnswersFromFile(correctAnswers);
    }
    @Override
    public List<Character> getStudentAnswersAsList() {
        return fileUtils.getAnswersFromFile(studentAnswers);
    }

}
