package pl.juniorjavadeveloper.project.weatherman;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;

class WeathermanApplicationTest {
    @AfterEach
    public void restoreStreams() {
        System.setIn(System.in);
    }

    @Test
    void dummyTest() {
        // given/when/then
        System.setIn(new ByteArrayInputStream("q".getBytes()));
        WeathermanApplication.main(new String[]{"args"});
    }
}