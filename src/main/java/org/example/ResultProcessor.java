package org.example;

import java.io.File;
import java.util.List;

public interface ResultProcessor {
    int getExaminationScores(List<Character> correctAnswers, List<Character> studentAnswers);
}
