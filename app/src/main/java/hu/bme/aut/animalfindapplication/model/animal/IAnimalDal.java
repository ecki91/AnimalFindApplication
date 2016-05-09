package hu.bme.aut.animalfindapplication.model.animal;

import java.util.List;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public interface IAnimalDal {

    List<Animal> getAllAnimals();
    void createAnimal(Animal animal);
    void deleteAnimal(Animal animal);
    void updateAnimal(Animal animal);
    List<Animal> getAllAnimalsForBreed(String breed);

}
