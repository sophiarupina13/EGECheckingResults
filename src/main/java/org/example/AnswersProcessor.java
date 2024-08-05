package org.example;

import java.util.List;

public interface AnswersProcessor {
    List<Character> getCorrectAnswersAsList();
    List<Character> getStudentAnswersAsList();
}
