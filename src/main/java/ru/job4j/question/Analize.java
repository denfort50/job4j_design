package ru.job4j.question;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> map = current.stream()
                .collect(Collectors.toMap(User::getId, user -> user));
        int changed = 0;
        int added = 0;
        int deleted = 0;
        int length = map.size();
        for (User u : previous) {
            User userMap = map.get(u.getId());
            map.put(u.getId(), u);
            if (userMap == null) {
                deleted++;
            } else if (!userMap.getName().equals(map.get(u.getId()).getName())) {
                changed++;
            }
            added = length - previous.size() + deleted;
        }
        return new Info(added, changed, deleted);
    }
}
