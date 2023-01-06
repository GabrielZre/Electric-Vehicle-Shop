package database;

import products.User;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

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
        for(User user : this.users) {
            if(user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    public void addUser(User user) {
        /*User[] newUsers = new User[this.users.length +1];
        for(int i=0; i < this.users.length; i++) {
           newUsers[i] = this.users[i];
        }*/
        this.users.add(user);
    }

    public boolean changeUserRole(String login, String role) {
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
    }

    public static UserDB getInstance() {
        return instance;
    }
}
