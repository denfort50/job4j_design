package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.*;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Denis"));
        assertThat(config.value("surname"), is(""));
    }

    @Test
    public void whenPairWithCommentAndEmptyLines() {
        String path = "./data/pair_with_comment_and_empty_lines.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Denis"));
        assertThat(config.value("surname"), is("Kalchenko"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenPairWithPatternViolation() {
        String path = "./data/pair_with_pattern_violation.properties";
        Config config = new Config(path);
        config.load();
    }
}
