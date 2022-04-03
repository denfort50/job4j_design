package ru.job4j.template;

import org.junit.Ignore;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class GeneratorFirstTest {

    @Ignore
    @Test
    public void whenCorrectArgsThenProduce() {
        GeneratorFirst generatorFirst = new GeneratorFirst();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Petr Arsentev");
        args.put("subject", "you");
        String result = "I am a Petr Arsentev, Who are you?";
        assertThat(generatorFirst.produce(template, args), is(result));
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenKeysIncorrectThenException() {
        GeneratorFirst generatorFirst = new GeneratorFirst();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("nickname", "job4j");
        args.put("subject", "you");
        generatorFirst.produce(template, args);
    }

    @Ignore
    @Test(expected = IllegalArgumentException.class)
    public void whenKeysToMuchThenException() {
        GeneratorFirst generatorFirst = new GeneratorFirst();
        String template = "I am a ${name}, Who are ${subject}?";
        Map<String, String> args = new HashMap<>();
        args.put("name", "Denis Kalchenko");
        args.put("favoriteCar", "Mercedes-Benz GLE Coupe AMG 63 AMG");
        args.put("subject", "you");
        generatorFirst.produce(template, args);
    }
}