package ru.job4j.ood.srp;

import java.io.File;

/**
 * Интерфейс Converter может конвертировать файл в JSON, XML и затем показать их на экране.
 */
public interface Converter {
    void convertToXML(File file);
    void convertToJSON(File file);
    void showXML(File file);
    void showJSON(File file);
}
