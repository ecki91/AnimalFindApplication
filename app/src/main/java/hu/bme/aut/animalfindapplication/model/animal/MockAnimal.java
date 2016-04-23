package hu.bme.aut.animalfindapplication.model.animal;

import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Norbert on 2016. 04. 23..
 */
public class MockAnimal extends SugarRecord implements IAnimalDal {
    @Override
    public List<Animal> listAllAnimals() {
        List<Animal> testList = new ArrayList<Animal>();

        Animal animal1 = new Animal();
        animal1.setId(1l);
        animal1.setAdvertisementTitle("Vizsla Berci");
        animal1.setLostOrFound("eltűnt");
        animal1.setCity("Budapest");
        animal1.setSpecies("kutya");
        animal1.setBreed("vizsla");
        animal1.setDate("2016-04-11");

        Animal animal2 = new Animal();
        animal2.setId(2l);
        animal2.setAdvertisementTitle("Talalt Cica");
        animal2.setLostOrFound("megtalált");
        animal2.setCity("Siófok");
        animal2.setSpecies("macska");
        animal2.setBreed("házi");
        animal2.setDate("2016-03-22");

        testList.add(animal1);
        testList.add(animal2);

        return testList;
    }
}
