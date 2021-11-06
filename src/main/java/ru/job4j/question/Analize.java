package ru.job4j.question;

import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> mapOfCurrent = current.stream()
                .collect(Collectors.toMap(User::getId, user -> user));
        int changed = 0;
        int added = 0;
        int deleted = 0;
        int lengthOfMap = mapOfCurrent.size();
        for (User userPrev : previous) {
            User userCurr = mapOfCurrent.get(userPrev.getId());
            mapOfCurrent.put(userPrev.getId(), userPrev);
            if (userCurr == null) {
                deleted++;
            } else if (!Objects.equals(userCurr.getName(), mapOfCurrent.get(userPrev.getId()).getName())) {
                changed++;
            }
            added = lengthOfMap - previous.size() + deleted;
        }
        return new Info(added, changed, deleted);
    }
}
