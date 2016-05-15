package hu.bme.aut.animalfindapplication.other;

import java.io.Serializable;

/**
 * Created by Norbert on 2016. 05. 15..
 */
public class BreedSearch implements Serializable {
    private String breed;

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
