package hu.bme.aut.animalfindapplication.interactor;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.User;
import hu.bme.aut.animalfindapplication.model.user.Animal;

/**
 * Created by Norbert on 2016. 04. 11..
 */
public class LoginInteractor {

    @Inject
    protected User user;

    @Inject
    protected Animal animal;

    public LoginInteractor() {
        AnimalFindApplication.injector.inject(this);
    }
}
