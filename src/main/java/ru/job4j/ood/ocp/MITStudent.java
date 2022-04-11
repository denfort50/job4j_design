package ru.job4j.ood.ocp;

import java.util.List;

/**
 * Класс описывает студента MIT
 */
public class MITStudent extends Student {

    /**
     * Метод реализует процесс обучения студента
     * @param books – книги, которые изучает студент
     * @return список работ, входящих в диссертацию
     */

    public List<String> study(List<String> books) {
        return null;
    }

    /**
     * Метод реализует процесс защиты диссертации
     * @param thesisDocuments – защищаемая диссертация
     * @return
     */

    public int thesisDefend(List<String> thesisDocuments) {
        return 0;
    }
}
