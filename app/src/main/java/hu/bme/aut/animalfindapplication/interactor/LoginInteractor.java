package hu.bme.aut.animalfindapplication.interactor;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;
import hu.bme.aut.animalfindapplication.model.user.User;

/**
 * Created by Norbert on 2016. 04. 11..
 */
public class LoginInteractor {

    @Inject
    protected IUserDal user;

    @Inject
    protected IAnimalDal animal;

    public LoginInteractor() {
        AnimalFindApplication.injector.inject(this);
    }

    public boolean login(User userToLogin) {
        return user.login(userToLogin);
    }

    public void logut() {

    }

    public void register(User userToRegister) {
        user.register(userToRegister);
    }
}
