package hu.bme.aut.animalfindapplication.ui.animalList;

import java.util.List;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.interactor.AnimalListInteractor;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
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

    public void getAnimals() {
        List<Animal> animalList = null;
        try {
            animalList = animalListInteractor.getAnimalListFromNetwork();
        } catch (Exception ex) {
            animalList = animalListInteractor.getAnimalList();
        }
        screen.getAnimalList(animalList);
    }

    public void getAnimalsForBreed(String breed) {
        try {
            screen.getAnimalList(animalListInteractor.getAnimalListForBreedFromNetwork(breed));
        } catch (Exception ex) {
            screen.getAnimalList(animalListInteractor.getAnimalListForBreed(breed));
        }

    }
}
