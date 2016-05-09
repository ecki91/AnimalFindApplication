package hu.bme.aut.animalfindapplication.ui.animalDetails;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.interactor.AnimalDetailsInteractor;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.user.User;
import hu.bme.aut.animalfindapplication.ui.Presenter;
import hu.bme.aut.animalfindapplication.ui.animalCreate.AnimalCreateScreen;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalDetailsPresenter extends Presenter<AnimalCreateScreen> {

    @Inject
    protected AnimalDetailsInteractor animalDetailsInteractor;

    public AnimalDetailsPresenter() {
        AnimalFindApplication.injector.inject(this);
    }

    public void modifyAnimal(Animal animal, User user) {
        animalDetailsInteractor.modifyAnimal(animal,user);
        screen.getAnimals();

    };
}
