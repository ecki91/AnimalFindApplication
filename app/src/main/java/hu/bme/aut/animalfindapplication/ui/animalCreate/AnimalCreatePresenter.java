package hu.bme.aut.animalfindapplication.ui.animalCreate;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.interactor.AnimalCreateInteractor;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.ui.Presenter;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalCreatePresenter extends Presenter<AnimalCreateScreen> {

    @Inject
    protected AnimalCreateInteractor animalCreateInteractor;

    public AnimalCreatePresenter() {
        AnimalFindApplication.injector.inject(this);
    }

    public void createAnimal(Animal animal) {
        animalCreateInteractor.createAnimal(animal);
        screen.getAnimals();
    }

}
