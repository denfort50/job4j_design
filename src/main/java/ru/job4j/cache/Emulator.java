package ru.job4j.cache;

import java.io.IOException;
import java.lang.ref.SoftReference;
import java.util.Scanner;

public class Emulator {

    DirFileCache dirFileCache = new DirFileCache(specifyTheCachedDirectory());
    String fileName = specifyTheFileName();

    public String specifyTheCachedDirectory() {
        System.out.println("Введите адрес кэшируемой директории: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public String specifyTheFileName() {
        System.out.println("Введите имя файла: ");
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

    public void loadContentToCache() throws IOException {
        String content = dirFileCache.load(fileName);
        dirFileCache.cache.put(fileName, new SoftReference<>(content));
        System.out.println("Файл загружен в кэш.");
    }

    public String getContentFromCache() {
        System.out.println("Содержимое файла: ");
        String result = dirFileCache.get(fileName);
        if (result.isEmpty()) {
            return "Файл отсутствует в кэше.";
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        Emulator emulator = new Emulator();
        emulator.loadContentToCache();
        System.out.println(emulator.getContentFromCache());
    }
}
