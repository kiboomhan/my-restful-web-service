package com.example.restfulwebservice.user;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Service // @Component
public class UserDaoService {
    private static List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    public static void setUsersCount(int toCount) {
        usersCount = toCount;
    }

    static {
        users.add(new User(1,"Kenneth", new Date(), "pass1", "101010-1111111"));
        users.add(new User(2,"Alice", new Date(), "pass2", "201010-2222222"));
        users.add(new User(3,"Elena", new Date(), "pass3", "301010-3333333"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        if (user.getId() == null) {
            // add
            setUsersCount(usersCount + 1);
            user.setId(usersCount);
            users.add(user);
        } else {
            // edit
            User targetUser = users.stream().filter(dbUser -> dbUser.getId().equals(user.getId()))
                    .findFirst()
                    .orElse(null);

            if (targetUser != null) {
                targetUser.setJoinDate(user.getJoinDate());
                targetUser.setName(user.getName());
                return targetUser;
            }
        }

        return user;
    }

    public User findOne(int id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public User deleteById(int id) {
        Iterator<User> iterator = users.iterator();

        while (iterator.hasNext()) {
            User user = iterator.next();

            if (user.getId().equals(id)) {
                iterator.remove();
                return user;
            }
        }

        return null;
    }

}

