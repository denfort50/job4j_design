package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> mapOfPrevious = previous.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        Map<Integer, String> mapOfCurrent = current.stream()
                .collect(Collectors.toMap(User::getId, User::getName));
        int changed = (int) mapOfCurrent.keySet()
                .stream()
                .filter(id -> mapOfPrevious.containsKey(id) && !mapOfPrevious.containsValue(mapOfCurrent.get(id)))
                .count();
        int added = (int) current.stream()
                .filter(uCurr -> !previous.stream()
                        .map(User::getId)
                        .collect(Collectors.toSet())
                        .contains(uCurr.getId()))
                .count();
        int deleted = (int) previous.stream()
                .filter(uPrev -> !current.stream()
                        .map(User::getId)
                        .collect(Collectors.toSet())
                        .contains(uPrev.getId()))
                .count();
        return new Info(added, changed, deleted);
    }

}
