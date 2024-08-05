package org.example;

import java.io.File;
import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.util.LinkedList;
import java.util.List;

public class FileUtils {

    public List<Character> getAnswersFromFile(File path) {
        StringBuilder fileToText = new StringBuilder();
        try (FileChannel inChannel = new FileInputStream(path).getChannel()) {
            ByteBuffer buffer = ByteBuffer.allocate((int) inChannel.size());
            inChannel.read(buffer);
            buffer.flip();
            fileToText.append(StandardCharsets.UTF_8.decode(buffer));
        } catch (Exception e) {
            System.out.println("Cannot read file: " + path);;
        }
        return textSplittedIntoAnswers(fileToText.toString());
    }

    private List<Character> textSplittedIntoAnswers(String inputData) {
        List<Character> answers = new LinkedList<>();
        String[] lines = inputData.split("\r\n");
        for (int i = 0; i < lines.length; i++) {
            answers.add(convertLineToAnswer(lines[i]));
        }
        return answers;
    }

    private Character convertLineToAnswer(String line) {
        return line.charAt(line.length() - 1);
    }
}
