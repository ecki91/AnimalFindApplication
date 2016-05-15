package hu.bme.aut.animalfindapplication.model.animal;

import java.util.List;

/**
 * Created by Norbert on 2016. 05. 15..
 */
public class AnimalDal implements IAnimalDal {

    @Override
    public List<Animal> getAllAnimals() {
        return Animal.find(Animal.class, null, null, null, null, null);
    }

    @Override
    public void createAnimal(Animal animal) {
        animal.save();
    }

    @Override
    public void deleteAnimal(Animal animal) {

    }

    @Override
    public void updateAnimal(Animal animal) {
        for(Animal a : getAllAnimals()) {
            if(a.getId().equals(animal.getId()))
            {
                Animal.delete(a);
                Animal.save(animal);
                return;
            }
        }

    }

    @Override
    public List<Animal> getAllAnimalsForBreed(String breed) {
        return Animal.find(Animal.class, "breed = ?", breed);
    }
}
