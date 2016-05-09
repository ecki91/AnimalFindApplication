package hu.bme.aut.animalfindapplication.model.user;

import com.orm.SugarRecord;

public class User extends SugarRecord implements IUserDal {
    private String name;
    private String username;
    private String password;
    private int age;


    public User() {

    }

    public User(String name, int age, String username, String password) {
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.age = -1;
        this.name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public void register(User user) {

    }

    @Override
    public boolean login(User user) {
        return true;
    }

    @Override
    public User getLoggedInUser() {
        return null;
    }
}
