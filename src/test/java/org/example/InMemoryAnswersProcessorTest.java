package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class InMemoryAnswersProcessorTest {

    private AnswersProcessor answersProcessor;

    @BeforeEach
    void setUp() {
        answersProcessor = new InMemoryAnswersProcessor();
    }

    @Test
    void getCorrectAnswersAsList() {
        assertEquals(List.of('А', 'Б', 'В', 'Г', 'Г', 'А', 'В', 'Г', 'Б', 'В'), answersProcessor.getCorrectAnswersAsList());
    }

    @Test
    void getStudentAnswersAsList() {
        assertNotEquals(List.of('А', 'Б', 'В', 'Г', 'Г', 'А', 'В', 'Г', 'Б', 'В'), answersProcessor.getStudentAnswersAsList());
    }
}