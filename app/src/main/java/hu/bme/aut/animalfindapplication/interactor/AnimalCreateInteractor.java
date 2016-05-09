package hu.bme.aut.animalfindapplication.interactor;

import javax.inject.Inject;

import hu.bme.aut.animalfindapplication.AnimalFindApplication;
import hu.bme.aut.animalfindapplication.model.animal.Animal;
import hu.bme.aut.animalfindapplication.model.animal.IAnimalDal;
import hu.bme.aut.animalfindapplication.model.user.IUserDal;

/**
 * Created by Norbert on 2016. 04. 22..
 */
public class AnimalCreateInteractor {

    @Inject
    protected IUserDal user;

    @Inject
    protected IAnimalDal animal;

    public AnimalCreateInteractor() {
        AnimalFindApplication.injector.inject(this);
    }

    public void createAnimal(Animal animalToCreate) {
        animalToCreate.setContactName(user.getLoggedInUser().getName());
        animal.createAnimal(animalToCreate);
    }

}
