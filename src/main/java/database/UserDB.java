package database;

import products.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static products.User.Role.valueOf;

public class UserDB {
    private List<User> users = new ArrayList<>();
    private static final UserDB instance = new UserDB();

    private UserDB() {
        users.add(new User("admin", "1671dfc274ad7e8d560df28ac0eb3e45", User.Role.ADMIN));
        users.add(new User("gabriel", "4754793fa06ffec9db217a94cc2215c3", User.Role.USER));
    }

    public List<User> getUsers() {
        return users;
    }


    public User findByLogin(String login) {
    /*
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }

    */
        return this.users.stream().filter( s -> s.getLogin().equals(login)).
                findFirst().orElse(null);
    }

    public void addUser(User user) {
        /*User[] newUsers = new User[this.users.length +1];
        for(int i=0; i < this.users.length; i++) {
           newUsers[i] = this.users[i];
        }*/
        this.users.add(user);
    }

    public boolean changeUserRole(String login, String role) {
        /*        findFirst().orElse(null);
        for(User user : this.users) {
            if(user.getLogin().equals(login) ){
                try {
                    user.setRole(User.Role.valueOf(role));
                    return true;

                } catch (IllegalArgumentException e) {
                    return false;
                }
            }
        }

        return false;
        */
        return this.users.stream()
                .filter(user -> user.getLogin().equals(login))
                .map(user -> {
                    user.setRole(User.Role.valueOf(role));
                    return true;
                })
                .findFirst()
                .orElse(false);
    }


    public static UserDB getInstance() {
        return instance;
    }
}
