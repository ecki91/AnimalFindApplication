package hu.bme.aut.animalfindapplication.model.animal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Norbert on 2016. 04. 23..
 */
public class MockAnimal      implements IAnimalDal {

    private List<Animal> animalList = new ArrayList<Animal>();
    private long idSequence;

    public MockAnimal() {
        idSequence = 0;

        Animal animal1 = new Animal();
        animal1.setId(idSequence++);
        animal1.setAdvertisementTitle("Vizsla Berci");
        animal1.setLostOrFound("eltűnt");
        animal1.setCity("Budapest");
        animal1.setSpecies("kutya");
        animal1.setBreed("vizsla");
        animal1.setDate("2016-04-11");
        animal1.setContactName("alma");

        Animal animal2 = new Animal();
        animal2.setId(idSequence++);
        animal2.setAdvertisementTitle("Talalt Cica");
        animal2.setLostOrFound("megtalált");
        animal2.setCity("Siófok");
        animal2.setSpecies("macska");
        animal2.setBreed("házi");
        animal2.setDate("2016-03-22");
        animal2.setContactName("alma");

        Animal animal3 = new Animal();
        animal3.setId(idSequence++);
        animal3.setAdvertisementTitle("Pindur");
        animal3.setLostOrFound("megtalált");
        animal3.setCity("Siófok");
        animal3.setSpecies("macska");
        animal3.setBreed("házi");
        animal3.setDate("2016-03-23");
        animal3.setContactName("alma");

        Animal animal4 = new Animal();
        animal4.setId(idSequence++);
        animal4.setAdvertisementTitle("Ranti");
        animal4.setLostOrFound("eltűnt");
        animal4.setCity("Budapest");
        animal4.setSpecies("kutya");
        animal4.setBreed("német juhász");
        animal4.setDate("2016-03-22");
        animal4.setContactName("alma");

        Animal animal5 = new Animal();
        animal5.setId(idSequence++);
        animal5.setAdvertisementTitle("Görényke");
        animal5.setLostOrFound("megtalált");
        animal5.setCity("Siófok");
        animal5.setSpecies("görény");
        animal5.setBreed("házi");
        animal5.setDate("2016-03-20");
        animal5.setContactName("alma");

        animalList.add(animal1);
        animalList.add(animal2);
        animalList.add(animal3);
        animalList.add(animal4);
        animalList.add(animal5);
    }

    @Override
    public List<Animal> getAllAnimals() {
        return animalList;
    }

    @Override
    public void createAnimal(Animal animal) {
        animal.setId(idSequence++);
        animalList.add(animal);
    }

    @Override
    public void deleteAnimal(Animal animal) {

    }

    @Override
    public void updateAnimal(Animal animal) {
        for(Animal a : animalList) {
            if(a.getId().equals(animal.getId()))
            {
                animalList.remove(a);
                animalList.add(animal);
                return;
            }
        }
    }

    @Override
    public List<Animal> getAllAnimalsForBreed(String breed) {
        List<Animal> returnList = new ArrayList<Animal>();
        if(breed.equals("")) {
            return animalList;
        }
        for(Animal a : animalList) {
            if(a.breed.equals(breed)) {
                returnList.add(a);
            }
        }
        return returnList;
    }
}
