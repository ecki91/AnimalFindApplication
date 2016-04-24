package hu.bme.aut.animalfindapplication.ui.animalCreateOrModify;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.interactor.AnimalCreateOrModifyInteractor;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.user.User;
import hu.bme.aut.animalfindapplication.ui.Presenter;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalCreateOrModifyPresenter extends Presenter<AnimalCreateOrModifyScreen> {

    @Inject
    protected AnimalCreateOrModifyInteractor animalCreateOrModifyInteractor;

    public AnimalCreateOrModifyPresenter() {
        AnimalFindApplication.injector.inject(this);
    }

    public void createAnimal(Animal animal) {

    }

    public void modifyAnimal(Animal animal, User user) {

    };
}
