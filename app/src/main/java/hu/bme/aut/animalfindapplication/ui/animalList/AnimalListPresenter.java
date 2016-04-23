package hu.bme.aut.animalfindapplication.ui.animalList;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.interactor.AnimalListInteractor;
import hu.bme.aut.animalfindapplication.model.user.Animal;
import hu.bme.aut.animalfindapplication.ui.Presenter;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalListPresenter extends Presenter<AnimalListScreen> {

    @Inject
    protected AnimalListInteractor animalListInteractor;

    public AnimalListPresenter() {
        AnimalFindApplication.injector.inject(this);
    }

    @Override
    public void attachScreen(AnimalListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getAnimals() {
        List<Animal> animalList = makeTestAnimalList();
        screen.showAnimalList(animalList);
    }

    private List<Animal> makeTestAnimalList() {
        List<Animal> testList = new ArrayList<Animal>();

        Animal animal1 = new Animal();
        animal1.setId(1);
        animal1.setAdvertisementTitle("Vizsla Berci");
        animal1.setLostOrFound("eltűnt");
        animal1.setCity("Budapest");
        animal1.setSpecies("kutya");
        animal1.setBreed("vizsla");
        animal1.setDate("2016-04-11");

        Animal animal2 = new Animal();
        animal2.setId(2);
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
