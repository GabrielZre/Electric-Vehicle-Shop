package database;

import products.ElectricVehicle;
import products.User;

public class UserDB {
    private User[] users = new User[2];
    private static final UserDB instance = new UserDB();

    private UserDB() {
        this.users[0] = new User("admin", "eb0468abcd9f88e9844fd140fbb6acff", User.Role.ADMIN);
        this.users[1] = new User("gabriel", "6fff9bb96e12805ea3ccb8ec27e8206f", User.Role.USER);
    }

    public User[] getUsers() {
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
        User[] newUsers = new User[this.users.length +1];
        for(int i=0; i < this.users.length; i++) {
            newUsers[i] = this.users[i];
        }
        newUsers[newUsers.length - 1] = user;
        this.users = newUsers;
    }

    public boolean changeUserRole(String login, String role) {
        for(User user : this.users) {
            if(user.getLogin().equals(login) ){
                    user.setRole(User.Role.valueOf(role));
                    return true;
                }
            }

        return false;
    }

    public static UserDB getInstance() {
        return instance;
    }
}
