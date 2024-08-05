package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryResultProcessorTest {

    List<Integer> taskScores = List.of(1, 1, 1, 1, 2, 2, 2, 2, 3, 3);
    private AnswersProcessor answersProcessor = new InMemoryAnswersProcessor();
    private ResultProcessor resultProcessor = new InMemoryResultProcessor(taskScores, answersProcessor);
    private FileUtils fileUtils = new FileUtils();
    final File correctAnswers = new File("./src/main/resources/correct-answers.txt");
    final File studentCorrectAnswers = new File("./src/main/resources/correct-answers.txt");

    @Test
    void getExaminationScores() {
        assertEquals(18, resultProcessor.getExaminationScores(fileUtils.getAnswersFromFile(correctAnswers), fileUtils.getAnswersFromFile(studentCorrectAnswers)));
    }
}