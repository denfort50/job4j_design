package ru.job4j.assertj;

import org.assertj.core.data.Index;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class SimpleConvertTest {

    @Test
    void checkArray() {
        SimpleConvert simpleConvert = new SimpleConvert();
        String[] array = simpleConvert.toArray("first", "second", "three", "four", "five");
        assertThat(array).hasSize(5)
                .contains("second")
                .contains("first", Index.atIndex(0))
                .containsAnyOf("zero", "second", "six")
                .doesNotContain("first", Index.atIndex(1));
    }

    @Test
    void checkList() {
        SimpleConvert simpleConvert = new SimpleConvert();
        List<String> list = simpleConvert.toList("first", "second", "three", "four", "five");
        assertThat(list).hasSize(5)
                .isNotNull()
                .contains("four")
                .doesNotContain("seven")
                .allMatch(e -> e.length() < 7)
                .element(0).isNotNull().isEqualTo("first");
    }

    @Test
    void checkSet() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Set<String> set = simpleConvert.toSet("first", "second", "three", "four", "five");
        assertThat(set).isNotNull()
                .hasSize(5)
                .anyMatch(e -> e.length() == 6)
                .noneMatch(e -> e.length() < 3)
                .containsAnyOf("second", "six", "nine")
                .allMatch(e -> e.length() >= 4);
    }

    @Test
    void checkMap() {
        SimpleConvert simpleConvert = new SimpleConvert();
        Map<String, Integer> map = simpleConvert.toMap("first", "second", "three", "four", "five");
        assertThat(map).isNotNull()
                .hasSize(5)
                .containsKeys("first", "three")
                .containsValues(3, 4)
                .doesNotContainKey("eleven")
                .doesNotContainValue(11)
                .containsEntry("four", 3);
    }
}