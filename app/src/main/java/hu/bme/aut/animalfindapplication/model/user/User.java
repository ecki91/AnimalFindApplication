package hu.bme.aut.animalfindapplication.model.user;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;

public class User extends SugarRecord implements Serializable {
    @SerializedName("name")
    private String name;
    @SerializedName("password")
    private String password;

    public User() {

    }

    public User(String name, int age, String username, String password) {
        this.name = name;
        this.password = password;
    }

    public User(String username, String password) {
        this.password = password;
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

}
