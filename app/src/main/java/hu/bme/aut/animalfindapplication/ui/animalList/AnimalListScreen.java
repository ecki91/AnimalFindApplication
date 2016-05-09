package hu.bme.aut.animalfindapplication.ui.animalList;

import java.util.List;

import hu.bme.aut.animalfindapplication.model.animal.Animal;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public interface AnimalListScreen {
    void getAnimalList(List<Animal> animalList);

    public void getAnimalsForBreed(String breedFilter);
}
