package org.example;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class InMemoryResultProcessor implements ResultProcessor {

    @Value("#{'${task.evaluation}'.split(',')}")
    private List<Integer> taskScores;
    private final AnswersProcessor answersProcessor;

    public InMemoryResultProcessor(AnswersProcessor answersProcessor) {
        this.answersProcessor = answersProcessor;
    }

    public InMemoryResultProcessor(List<Integer> taskScores, AnswersProcessor answersProcessor) {
        this.taskScores = taskScores;
        this.answersProcessor = answersProcessor;
    }

    @Override
    public int getExaminationScores(List<Character> correctAnswers, List<Character> studentAnswers) {
        Map<Integer, Integer> answers = new LinkedHashMap<>();

        for (int i = 0; i < correctAnswers.size(); i++) {
            if (studentAnswers.get(i).equals(correctAnswers.get(i))) {
                answers.put(i, 1);
            } else {
                answers.put(i, 0);
            }
        }

        return totalScores(answers);
    }

    private int totalScores(Map<Integer, Integer> answers) {
        int result = 0;
        int count = 0;

        for (Integer correctness : answers.values()) {
            int coefficient = taskScores.get(count);
            result += correctness * coefficient;
            count++;
        }

        return result;
    }
}
