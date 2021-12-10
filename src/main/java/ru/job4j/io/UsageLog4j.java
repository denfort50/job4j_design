package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Denis Kalchenko";
        byte workExperience = 2;
        short yearOfBorn = 1995;
        int age = 26;
        long motherlandPopulation = 145975300;
        float eyesight = 1.0f;
        double averageUniversityScore = 4.4;
        char usingCurrency = '₽';
        boolean married = true;
        LOG.debug("User info name: {}, workExperience: {}, yearOfBorn: {}, age: {}, motherlandPopulation: {}, "
                        + "eyesight: {}, averageUniversityScore: {},  usingCurrency: {}, married: {}",
                name, workExperience, yearOfBorn, age, motherlandPopulation,
                eyesight, averageUniversityScore, usingCurrency, married);
    }
}
