package hu.bme.aut.animalfindapplication.model.animal;

import java.util.List;

import hu.bme.aut.animalfindapplication.model.animal.Animal;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public interface IAnimalDal {

    List<Animal> listAllAnimals();
}
