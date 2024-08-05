package org.example;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class FileUtilsTest {

    private FileUtils fileUtils = new FileUtils();
    final File path = new File("./resources/file.txt");

    @Test
    void getAnswersFromFile() {
        assertThrows(FileNotFoundException.class, () -> fileUtils.getAnswersFromFile(path));
    }
}