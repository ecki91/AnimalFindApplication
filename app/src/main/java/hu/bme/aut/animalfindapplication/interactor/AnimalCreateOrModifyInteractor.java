package hu.bme.aut.animalfindapplication.interactor;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.User;
import hu.bme.aut.animalfindapplication.model.user.Animal;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalCreateOrModifyInteractor {

    @Inject
    protected User user;

    @Inject
    protected Animal animal;

    public AnimalCreateOrModifyInteractor() {
        AnimalFindApplication.injector.inject(this);
    }

}
