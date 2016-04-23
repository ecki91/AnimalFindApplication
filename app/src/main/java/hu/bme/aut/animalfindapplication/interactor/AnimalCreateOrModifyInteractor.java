package hu.bme.aut.animalfindapplication.interactor;

import javax.inject.Inject;

import hu.aut.bme.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalCreateOrModifyInteractor {

    @Inject
    protected IUserDal user;

    @Inject
    protected IAnimalDal animal;

    public AnimalCreateOrModifyInteractor() {
        AnimalFindApplication.injector.inject(this);
    }

}
