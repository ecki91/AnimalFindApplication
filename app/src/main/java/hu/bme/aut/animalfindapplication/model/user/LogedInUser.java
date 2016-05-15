package hu.bme.aut.animalfindapplication.model.user;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

import java.io.Serializable;

/**
 * Created by Norbert on 2016. 05. 12..
 */
public class LogedInUser extends SugarRecord implements Serializable {

    public LogedInUser() {

    }
    @SerializedName("name")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
