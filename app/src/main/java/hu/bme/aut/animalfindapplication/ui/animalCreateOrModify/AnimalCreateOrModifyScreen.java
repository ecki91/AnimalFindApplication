package hu.bme.aut.animalfindapplication.ui.animalCreateOrModify;

import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.user.User;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public interface AnimalCreateOrModifyScreen {

    public void createAnimal(Animal animal);

    public void modifyAnimal(Animal animal, User user);
}
