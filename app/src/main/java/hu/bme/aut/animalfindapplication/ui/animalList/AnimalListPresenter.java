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

    @Override
    public void attachScreen(AnimalListScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void getAnimals() {
        List<Animal> animalList = animalListInteractor.getAnimalList();
        screen.showAnimalList(animalList);
    }

    public void getAnimalsForBreed() {

    }
}
