package hu.bme.aut.animalfindapplication.model.user;

import com.orm.SugarRecord;

/**
 * Created by Norbert on 2016. 05. 12..
 */
public class LogedInUser extends SugarRecord {

    public LogedInUser() {

    }
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
