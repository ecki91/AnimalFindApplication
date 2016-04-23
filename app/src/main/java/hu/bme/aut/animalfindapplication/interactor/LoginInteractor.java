package hu.bme.aut.animalfindapplication.interactor;

import javax.inject.Inject;

import hu.aut.bme.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;

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
}
