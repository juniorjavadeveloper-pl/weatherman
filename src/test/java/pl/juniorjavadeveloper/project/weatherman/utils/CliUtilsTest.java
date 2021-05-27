package pl.juniorjavadeveloper.project.weatherman.utils;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CliUtilsTest {
    @Test
    void textInputWait() {
        // given
        String input = "Some input text";

        // when
        String text = CliUtils.textInputWait(new Scanner(input), "Wait Message");

        // then
        assertEquals(input, text, "Input and Text not equal");
    }
}