package ru.job4j.question;

import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int changed = 0;
        for (User uCurr : current) {
            for (User uPrev : previous) {
                if (uPrev.getId() == uCurr.getId() && !Objects.equals(uPrev.getName(), uCurr.getName())) {
                    changed++;
                }
            }
        }
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
